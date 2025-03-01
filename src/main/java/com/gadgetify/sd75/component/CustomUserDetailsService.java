package com.gadgetify.sd75.component;

import com.gadgetify.sd75.entity.NguoiDung;
import com.gadgetify.sd75.repository.NguoiDungRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private NguoiDungRepository nguoiDungRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        NguoiDung nguoiDung = nguoiDungRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Không tìm thấy người dùng với email: " + email));

        return new User(
                nguoiDung.getEmail(),
                nguoiDung.getMatKhau(),
                List.of(new SimpleGrantedAuthority(nguoiDung.getVaiTro().getTenVaiTro())
        ));
    }
}
