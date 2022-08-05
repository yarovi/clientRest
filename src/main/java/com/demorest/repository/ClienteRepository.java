package com.demorest.repository;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.demorest.entity.Cliente;

@Mapper
public interface ClienteRepository {

	@Select("Select * from cliente")
	public List<Cliente> findAll();
	
	@Select("Select * from cliente where codigo= #{codigo}")
	public Cliente findById(int codigo);
	
	@Insert("insert into cliente (codigo,nroDocumento,nombres,prestamo,cantidad)" +
			"values (#{codigo},#{nroDocumento},#{nombres},#{prestamo},#{cantidad})")
	public int insert(Cliente cliente);
	
	@Update("update cliente set nombres =#{nombres} where codigo=#{codigo}")
	public int update(Cliente cliente);
}
