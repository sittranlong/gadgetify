package com.gadgetify.sd75.service.impl;

import com.gadgetify.sd75.dto.request.*;
import com.gadgetify.sd75.dto.response.*;
import com.gadgetify.sd75.entity.*;
//import com.gadgetify.sd75.enums.ResponseCode;
import com.gadgetify.sd75.mapper.GadgetifyMapper;
import com.gadgetify.sd75.repository.*;
import com.gadgetify.sd75.service.KhachHangService;
import com.gadgetify.sd75.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class KhachHangServiceImpl implements KhachHangService {

    @Autowired
    private SanPhamRepository sanPhamRepository;

    @Autowired
    private BienTheSanPhamRepository bienTheSanPhamRepository;

    @Autowired
    private DanhMucRepository danhMucRepository;

    @Autowired
    private KhuyenMaiRepository khuyenMaiRepository;

    @Autowired
    private GioHangRepository gioHangRepository;

    @Autowired
    private ChiTietGioHangRepository chiTietGioHangRepository;

    @Autowired
    private NguoiDungRepository nguoiDungRepository;

    @Autowired
    private DonHangRepository donHangRepository;

    @Autowired
    private ChiTietDonHangRepository chiTietDonHangRepository;

    @Autowired
    private VaiTroRepository vaiTroRepository;


    @Autowired
    private GadgetifyMapper mapper;


    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private JwtUtil jwtUtil;

    private static final long GIO_HANG_HET_HAN_PHUT = 30;
    private static final long THOI_GIAN_HET_HAN_TOKEN_PHUT = 15;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public TrangChuResponse layTrangChu(TrangChuRequest request) {
        TrangChuResponse response = new TrangChuResponse();

        // Hiển thị sản phẩm mới nhất
        List<SanPham> dsSanPhamMoi = sanPhamRepository.findTopNewProducts()
                .stream()
                .limit(request.getGioiHanSanPhamMoi())
                .toList();
        response.setDsSanPhamMoi(mapper.toDsChiTietSanPhamResponse(dsSanPhamMoi));

        // Hiển thị khuyến mãi
        List<KhuyenMai> dsKhuyenMai = khuyenMaiRepository.findByTrangThai(true)
                .stream()
                .limit(request.getGioiHanKhuyenMai())
                .toList();
        response.setDsKhuyenMai(mapper.toDsKhuyenMaiResponse(dsKhuyenMai));

        return response;
    }

    @Override
    public TimKiemLocResponse timKiemVaLocSanPham(TimKiemLocRequest request) {
        TimKiemLocResponse response = new TimKiemLocResponse();

        // Tìm kiếm theo từ khóa
        List<SanPham> dsSanPhamTimKiem = request.getTuKhoa() != null && !request.getTuKhoa().isEmpty()
                ? sanPhamRepository.findByTenSanPhamContainingIgnoreCase(request.getTuKhoa())
                : sanPhamRepository.findAll();

        // Lọc theo danh mục nếu có (không gán lại dsSanPhamTimKiem)
        final List<SanPham> dsSanPham = request.getMaDanhMuc() != null
                ? dsSanPhamTimKiem.stream()
                .filter(sp -> sp.getDanhMuc().getMaDanhMuc().equals(request.getMaDanhMuc()))
                .toList()
                : dsSanPhamTimKiem;

        // Lấy tất cả biến thể của các sản phẩm tìm được
        List<BienTheSanPham> dsBienThe = bienTheSanPhamRepository.filterBienTheSanPham(
                        request.getMauSac(),
                        request.getKichCo(),
                        request.getGiaToiThieu(),
                        request.getGiaToiDa()
                ).stream()
                .filter(bt -> dsSanPham.stream().anyMatch(sp -> sp.getMaSanPham().equals(bt.getSanPham().getMaSanPham())))
                .toList();

        response.setDsSanPham(mapper.toDsBienTheSanPhamResponse(dsBienThe));
        return response;
    }

    @Override
    public List<DanhMucResponse> layTatCaDanhMuc() {
        List<DanhMuc> dsDanhMuc = danhMucRepository.findAll();
        return mapper.toDsDanhMucResponse(dsDanhMuc);
    }

    @Override
    public ChiTietSanPhamResponse layChiTietSanPham(UUID maSanPham) {
        SanPham sanPham = sanPhamRepository.findById(maSanPham)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy sản phẩm"));

        ChiTietSanPhamResponse response = mapper.toChiTietSanPhamResponse(sanPham);
        List<BienTheSanPham> dsBienThe = bienTheSanPhamRepository.findBySanPham_MaSanPham(maSanPham);
        response.setDsBienThe(mapper.toDsBienTheSanPhamResponse(dsBienThe));
        return response;
    }

    @Override
    @Transactional
    public void themVaoGioHang(ThemVaoGioHangRequest request) {
        // Tìm hoặc tạo giỏ hàng
        GioHang gioHang;
        if (request.getMaNguoiDung() != null) {
            gioHang = gioHangRepository.findByKhachHang_MaNguoiDung(request.getMaNguoiDung())
                    .orElseGet(() -> {
                        GioHang gioHangMoi = new GioHang();
                        gioHangMoi.setKhachHang(new NguoiDung());
                        gioHangMoi.getKhachHang().setMaNguoiDung(request.getMaNguoiDung());
                        gioHangMoi.setNgayTao(LocalDateTime.now());
                        gioHangMoi.setNgayCapNhat(LocalDateTime.now());
                        return gioHangRepository.save(gioHangMoi);
                    });
        } else if (request.getSessionId() != null) {
            gioHang = gioHangRepository.findBySessionId(request.getSessionId())
                    .orElseGet(() -> {
                        GioHang gioHangMoi = new GioHang();
                        gioHangMoi.setSessionId(request.getSessionId());
                        gioHangMoi.setNgayTao(LocalDateTime.now());
                        gioHangMoi.setNgayCapNhat(LocalDateTime.now());
                        return gioHangRepository.save(gioHangMoi);
                    });
        } else {
            throw new RuntimeException("Yêu cầu MaNguoiDung hoặc SessionId");
        }

        // Kiểm tra biến thể sản phẩm
        BienTheSanPham bienThe = bienTheSanPhamRepository.findById(request.getMaBienTheSanPham())
                .orElseThrow(() -> new RuntimeException("Không tìm thấy biến thể sản phẩm"));

        // Kiểm tra số lượng tồn kho
        if (bienThe.getSoLuongTonKho() < request.getSoLuong()) {
            throw new RuntimeException("Không đủ hàng trong kho");
        }

        // Kiểm tra giới hạn < 3 trong giỏ hàng
        List<ChiTietGioHang> dsChiTietGioHang = chiTietGioHangRepository.findByGioHang_MaGioHang(gioHang.getMaGioHang());
        int soLuongHienTai = dsChiTietGioHang.stream()
                .filter(ct -> ct.getBienTheSanPham().getMaBienThe().equals(request.getMaBienTheSanPham()))
                .mapToInt(ChiTietGioHang::getSoLuong)
                .sum();

        if (soLuongHienTai + request.getSoLuong() >= 3) {
            throw new RuntimeException("Giới hạn tối đa 3 sản phẩm cùng loại. Vui lòng liên hệ cửa hàng để đặt số lượng lớn hơn.");
        }

        // Thêm hoặc cập nhật chi tiết giỏ hàng
        Optional<ChiTietGioHang> chiTietTonTai = dsChiTietGioHang.stream()
                .filter(ct -> ct.getBienTheSanPham().getMaBienThe().equals(request.getMaBienTheSanPham()))
                .findFirst();

        if (chiTietTonTai.isPresent()) {
            ChiTietGioHang chiTiet = chiTietTonTai.get();
            chiTiet.setSoLuong(chiTiet.getSoLuong() + request.getSoLuong());
            chiTietGioHangRepository.save(chiTiet);
        } else {
            ChiTietGioHang chiTietMoi = new ChiTietGioHang();
            chiTietMoi.setGioHang(gioHang);
            chiTietMoi.setBienTheSanPham(bienThe);
            chiTietMoi.setSoLuong(request.getSoLuong());
            chiTietGioHangRepository.save(chiTietMoi);
        }

        // Cập nhật thời gian giỏ hàng
        gioHang.setNgayCapNhat(LocalDateTime.now());
        gioHangRepository.save(gioHang);
    }

    @Override
    public GioHangResponse layGioHang(UUID maNguoiDung, String sessionId) {
        GioHang gioHang;
        if (maNguoiDung != null) {
            gioHang = gioHangRepository.findByKhachHang_MaNguoiDung(maNguoiDung)
                    .orElseThrow(() -> new RuntimeException("Không tìm thấy giỏ hàng cho người dùng"));
        } else if (sessionId != null) {
            gioHang = gioHangRepository.findBySessionId(sessionId)
                    .orElseThrow(() -> new RuntimeException("Không tìm thấy giỏ hàng cho phiên này"));
        } else {
            throw new RuntimeException("Yêu cầu MaNguoiDung hoặc SessionId");
        }

        GioHangResponse response = mapper.toGioHangResponse(gioHang);
        List<ChiTietGioHang> dsChiTietGioHang = chiTietGioHangRepository.findByGioHang_MaGioHang(gioHang.getMaGioHang());
        List<ChiTietGioHangResponse> dsChiTietResponse = mapper.toDsChiTietGioHangResponse(dsChiTietGioHang);

        // Tính tổng giá trị
        BigDecimal tongGiaTri = dsChiTietGioHang.stream()
                .map(ct -> ct.getBienTheSanPham().getGia().multiply(BigDecimal.valueOf(ct.getSoLuong())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        response.setTongGiaTri(tongGiaTri);

        // Gán thành tiền cho từng chi tiết giỏ hàng
        dsChiTietResponse.forEach(ct -> {
            BienTheSanPham bienThe = bienTheSanPhamRepository.findById(ct.getBienTheSanPham().getMaBienThe()).get();
            ct.setThanhTien(bienThe.getGia().multiply(BigDecimal.valueOf(ct.getSoLuong())));
        });

        response.setDsChiTietGioHang(dsChiTietResponse);
        return response;
    }

    @Override
    @Transactional
    public void capNhatGioHang(CapNhatGioHangRequest request) {
        ChiTietGioHang chiTiet = chiTietGioHangRepository.findById(request.getMaChiTietGioHang())
                .orElseThrow(() -> new RuntimeException("Không tìm thấy chi tiết giỏ hàng"));

        BienTheSanPham bienThe = chiTiet.getBienTheSanPham();
        if (bienThe.getSoLuongTonKho() < request.getSoLuong()) {
            throw new RuntimeException("Không đủ hàng trong kho");
        }

        // Kiểm tra giới hạn < 3
        if (request.getSoLuong() >= 3) {
            throw new RuntimeException("Giới hạn tối đa 3 sản phẩm cùng loại.");
        }

        chiTiet.setSoLuong(request.getSoLuong());
        chiTietGioHangRepository.save(chiTiet);

        GioHang gioHang = chiTiet.getGioHang();
        gioHang.setNgayCapNhat(LocalDateTime.now());
        gioHangRepository.save(gioHang);
    }

    @Override
    @Transactional
    public void xoaSanPhamKhoiGio(XoaSanPhamKhoiGioRequest request) {
        ChiTietGioHang chiTiet = chiTietGioHangRepository.findById(request.getMaChiTietGioHang())
                .orElseThrow(() -> new RuntimeException("Không tìm thấy chi tiết giỏ hàng"));

        GioHang gioHang = chiTiet.getGioHang();
        chiTietGioHangRepository.delete(chiTiet);

        gioHang.setNgayCapNhat(LocalDateTime.now());
        gioHangRepository.save(gioHang);
    }

    @Override
    @Transactional
    public void xoaGioHangHetHan() {
        LocalDateTime thoiDiemHienTai = LocalDateTime.now();
        List<GioHang> dsGioHang = gioHangRepository.findAll();

        dsGioHang.stream()
                .filter(gioHang -> gioHang.getKhachHang() == null) // Chỉ xóa giỏ hàng của khách chưa đăng nhập
                .filter(gioHang -> gioHang.getNgayCapNhat()
                        .plusMinutes(GIO_HANG_HET_HAN_PHUT)
                        .isBefore(thoiDiemHienTai))
                .forEach(gioHang -> {
                    chiTietGioHangRepository.deleteAll(
                            chiTietGioHangRepository.findByGioHang_MaGioHang(gioHang.getMaGioHang())
                    );
                    gioHangRepository.delete(gioHang);
                });
    }


    @Override
    @Transactional
    public void xacMinhTaiKhoan(XacMinhTaiKhoanRequest request) {
        NguoiDung nguoiDung = nguoiDungRepository.findById(request.getMaNguoiDung())
                .orElseThrow(() -> new RuntimeException("Không tìm thấy người dùng"));

        // Giả lập kiểm tra mã xác minh (thực tế cần lưu mã vào DB hoặc Redis)
        String maXacMinhDuocLuu = "123456"; // Giả lập, thay bằng logic thực tế
        if (!maXacMinhDuocLuu.equals(request.getMaXacMinh())) {
            throw new RuntimeException("Mã xác minh không đúng");
        }

        nguoiDung.setTrangThai(true); // Kích hoạt tài khoản
        nguoiDung.setNgayCapNhat(LocalDateTime.now());
        nguoiDungRepository.save(nguoiDung);
    }

    @Override
    public DangNhapResponse dangNhap(DangNhapRequest request) {
        NguoiDung nguoiDung = nguoiDungRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("Email hoặc mật khẩu không đúng"));

        if (!passwordEncoder.matches(request.getMatKhau(), nguoiDung.getMatKhau())) {
            throw new RuntimeException("Email hoặc mật khẩu không đúng");
        }

        if (!nguoiDung.getTrangThai()) {
            throw new RuntimeException("Tài khoản chưa được xác minh");
        }

        String token = jwtUtil.taoToken(nguoiDung.getEmail(), nguoiDung.getVaiTro().getTenVaiTro());
        DangNhapResponse response = mapper.toDangNhapResponse(nguoiDung);
        response.setToken(token);
        return response;
    }

    @Override
    public void dangXuat(String token) {
        // Với JWT, không cần logic server-side phức tạp vì token là stateless
        // Client chỉ cần xóa token khỏi local storage
        if (!jwtUtil.kiemTraTokenHopLe(token)) {
            throw new RuntimeException("Token không hợp lệ hoặc đã hết hạn");
        }
        // Có thể lưu token hết hạn vào blacklist nếu cần (tùy yêu cầu bảo mật)
    }

    @Override
    public void khoiPhucMatKhau(KhoiPhucMatKhauRequest request) {
        NguoiDung nguoiDung = nguoiDungRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("Email không tồn tại"));

        // Giả lập gửi email khôi phục mật khẩu
        String maXacMinh = UUID.randomUUID().toString().substring(0, 6); // Mã 6 ký tự
        guiEmailKhoiPhucMatKhau(nguoiDung.getEmail(), nguoiDung.getMaNguoiDung(), maXacMinh);
    }



    @Override
    public LichSuMuaHangResponse xemLichSuMuaHang(LichSuMuaHangRequest request) {
        NguoiDung nguoiDung = nguoiDungRepository.findById(request.getMaNguoiDung())
                .orElseThrow(() -> new RuntimeException("Không tìm thấy người dùng"));

        // Tạo đối tượng Pageable từ page và size
        Pageable pageable = PageRequest.of(request.getPage(), request.getSize());

        // Lấy danh sách đơn hàng phân trang
        Page<DonHang> donHangPage = donHangRepository.findByKhachHang_MaNguoiDung(request.getMaNguoiDung(), pageable);

        LichSuMuaHangResponse response = new LichSuMuaHangResponse();
        List<DonHangResponse> dsDonHangResponse = mapper.toDsDonHangResponse(donHangPage.getContent());

        // Lấy chi tiết đơn hàng cho từng đơn
        dsDonHangResponse.forEach(donHang -> {
            List<ChiTietDonHang> dsChiTietDonHang = chiTietDonHangRepository.findByDonHang_MaDonHang(donHang.getMaDonHang());
            donHang.setDsChiTietDonHang(mapper.toDsChiTietDonHangResponse(dsChiTietDonHang));
        });

        // Gán thông tin phân trang
        response.setDsDonHang(dsDonHangResponse);
        response.setTrangHienTai(donHangPage.getNumber());
        response.setTongSoTrang(donHangPage.getTotalPages());
        response.setTongSoPhanTu(donHangPage.getTotalElements());
        response.setKichThuocTrang(donHangPage.getSize());

        return response;
    }


    @Override
    @Transactional
    public DangKyResponse dangKy(DangKyRequest request) {


        // Kiểm tra vai trò hợp lệ
        VaiTro vaiTro = vaiTroRepository.findVaiTroByTenVaiTro(request.getVaiTro()).orElse(null);


        // Tạo tài khoản mới
        NguoiDung nguoiDung = new NguoiDung();
        nguoiDung.setTenNguoiDung(request.getTenNguoiDung());
        nguoiDung.setEmail(request.getEmail());
        nguoiDung.setMatKhau(passwordEncoder.encode(request.getMatKhau()));
        nguoiDung.setSoDienThoai(request.getSoDienThoai());
        nguoiDung.setTrangThai(false); // Chưa xác minh
        nguoiDung.setNgayTao(LocalDateTime.now());
        nguoiDung.setNgayCapNhat(LocalDateTime.now());
        nguoiDung.setProvider("LOCAL");
        nguoiDung.setProviderId(null);
        nguoiDung.setVaiTro(vaiTro);

        // Tạo và lưu mã xác minh
        String maXacMinh = UUID.randomUUID().toString().substring(0, 6);
        nguoiDung.setMaXacMinh(maXacMinh);
        nguoiDung.setLoaiMaXacMinh("XacMinh");
        nguoiDung.setThoiGianHetHanMaXacMinh(LocalDateTime.now().plusMinutes(THOI_GIAN_HET_HAN_TOKEN_PHUT));

        // Lưu vào database
        NguoiDung savedNguoiDung = nguoiDungRepository.save(nguoiDung);

        // Gửi email xác minh
        guiEmailXacMinh(savedNguoiDung.getEmail(), savedNguoiDung.getMaNguoiDung(), maXacMinh);

        // Chuyển đổi sang response
        DangKyResponse response = mapper.toDangKyResponse(savedNguoiDung);
        response.setThongBao("Vui lòng kiểm tra email để xác minh tài khoản");

        //gửi mail

        return response;
    }





    @Override
    @Transactional
    public void datLaiMatKhau(DatLaiMatKhauRequest request) {
        NguoiDung nguoiDung = nguoiDungRepository.findById(request.getMaNguoiDung())
                .orElseThrow(() -> new RuntimeException("Không tìm thấy người dùng"));

        if (nguoiDung.getMaXacMinh() == null || !"KhoiPhuc".equals(nguoiDung.getLoaiMaXacMinh()) ||
                nguoiDung.getThoiGianHetHanMaXacMinh().isBefore(LocalDateTime.now())) {
            throw new RuntimeException("Mã xác minh đã hết hạn hoặc không tồn tại");
        }

        if (!nguoiDung.getMaXacMinh().equals(request.getMaXacMinh())) {
            throw new RuntimeException("Mã xác minh không đúng");
        }

        // Xóa mã xác minh sau khi sử dụng
        nguoiDung.setMaXacMinh(null);
        nguoiDung.setLoaiMaXacMinh(null);
        nguoiDung.setThoiGianHetHanMaXacMinh(null);
        nguoiDung.setMatKhau(passwordEncoder.encode(request.getMatKhauMoi()));
        nguoiDung.setNgayCapNhat(LocalDateTime.now());
        nguoiDungRepository.save(nguoiDung);
    }

    private void guiEmailXacMinh(String email, UUID maNguoiDung, String maXacMinh) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject("Xác minh tài khoản GADGETIFY");
        message.setText("Mã xác minh của bạn là: " + maXacMinh + "\n" +
                "Vui lòng sử dụng mã này để kích hoạt tài khoản với MaNguoiDung: " + maNguoiDung);
        mailSender.send(message);
    }

    private void guiEmailKhoiPhucMatKhau(String email, UUID maNguoiDung, String maXacMinh) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject("Khôi phục mật khẩu GADGETIFY");
        message.setText("Mã khôi phục mật khẩu của bạn là: " + maXacMinh + "\n" +
                "Vui lòng sử dụng mã này để đặt lại mật khẩu với MaNguoiDung: " + maNguoiDung);
        mailSender.send(message);
    }

}