package dtn.asm.service;

import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import dtn.asm.dao.AccountDAO;
import dtn.asm.dao.AuthoritiesDAO;
import dtn.asm.entity.Accounts;

@Service
public class UserService implements UserDetailsService {

	@Autowired
	SessionService sessionService;

	@Autowired
	AccountDAO accountDAO;

	@Autowired
	AuthoritiesDAO authoritiesDAO;

	@Autowired
	BCryptPasswordEncoder pe;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		BCryptPasswordEncoder pe = new BCryptPasswordEncoder();
		try {
//			Accounts accounts = accountDAO.findById(username).get();
			Accounts accounts = accountDAO.findByIdAndActiveTrue(username, true).get();
			String pass = accounts.getPassword();
//			List<String> list = authoritiesDAO.findRoleByUsername(username);
			String[] roles = accounts.getAuthorities().stream().map(map -> map.getRoleId().getId())
					.collect(Collectors.toList()).toArray(new String[0]);
			UserDetails userDetails = User.withUsername(username).password(pe.encode(pass)).roles(roles).build();
			return userDetails;
		} catch (Exception e) {
			e.printStackTrace();
			throw new UsernameNotFoundException(username + " not found!");
		}
	}

}
