package com.senac.muver;

import java.util.Optional;
import java.util.function.Consumer;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.ui.Model;
import org.springframework.util.Assert;

import com.senac.muver.model.Master;
import com.senac.muver.model.Musico;
import com.senac.muver.services.MasterService;
import com.senac.muver.services.MusicoService;

@SpringBootTest
class MaestrinoApplicationTests {

	@Test
	void contextLoads() {
	}
	
	//@Test
	void listaMusicos() {
		MasterService service = new MasterService();
		
		Iterable<Master> musicos = service.listaTodosUsuarios();
		musicos.forEach(new Consumer<Master>() {
			@Override
            public void accept(Master t) 
            { 
                System.out.println(t); 
            } 
		});
	}
	
	//@Test
	void musicoPorId() {
		MusicoService service = new MusicoService();
		
		System.out.println(service.musicoPorID(5));
		
	}
	
	@Test
	void existeUsuario() {
		MasterService service = new MasterService();
		
		Master m = service.existeUsuario("teste@teste", "teste");
		Assert.notNull(m,"erro");
	}
}
