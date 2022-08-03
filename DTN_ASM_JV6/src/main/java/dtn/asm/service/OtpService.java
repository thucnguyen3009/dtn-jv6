package dtn.asm.service;

import java.util.List;

import dtn.asm.entity.Otp;

public interface OtpService {
	List<Otp> findAll();

	Otp findById(Integer id);

	void create();

	void update();

	void delete(Integer id);
}
