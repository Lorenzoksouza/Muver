package com.senac.muver;

import java.util.function.Consumer;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.ui.Model;

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
	void existeUsuario() {
		MasterService service = new MasterService();
		Master master = service.existeUsuario("teste@teste", "teste");
		System.out.println(master);
	}
	
	@Test
	void listaMusicos() {
		MusicoService service = new MusicoService();
		
		Iterable<Musico> musicos = service.listaTodosMusicos();
		musicos.forEach(new Consumer<Musico>() {
			@Override
            public void accept(Musico t) 
            { 
  
                System.out.println(t); 
            } 
		});
		
		
	}
	
}
