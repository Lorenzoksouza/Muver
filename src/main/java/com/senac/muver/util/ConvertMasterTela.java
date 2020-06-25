package com.senac.muver.util;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

import org.apache.commons.io.IOUtils;

import com.senac.muver.model.Estudio;
import com.senac.muver.model.Luthier;
import com.senac.muver.model.Master;
import com.senac.muver.model.MasterTela;
import com.senac.muver.model.Musico;

public class ConvertMasterTela {

	public ArrayList<MasterTela> converteListaMasterEmMasterTela(ArrayList<Master> listaUsuarios) {
		
		ArrayList<MasterTela> usuariosTela = new ArrayList<MasterTela>();
		for (Master m : listaUsuarios) {
			MasterTela mt = new MasterTela();
			try { 
				InputStream initialStream =new ByteArrayInputStream(m.getFotoPerfil());
					    File targetFile = new File("src/main/resources/static/images/fotoPerfil" + m.getIdmaster() + ".tmp");
					    OutputStream outStream = new FileOutputStream(targetFile);
					 
					    byte[] buffer = new byte[8 * 1024];
					    int bytesRead;
					    while ((bytesRead = initialStream.read(buffer)) != -1) {
					        outStream.write(buffer, 0, bytesRead);
					    }
					    mt.setFotoPerfil(new File("images/fotoPerfil" + m.getIdmaster() + ".tmp"));
					    IOUtils.closeQuietly(initialStream);
					    IOUtils.closeQuietly(outStream);
		        } catch (Exception e) { 
		           e.printStackTrace(); 
		        }
			mt.setNome(m.getNome());
			mt.setDescricao(m.getDescricao());
			usuariosTela.add(mt);
		}
		return  usuariosTela;
	}

	public MasterTela converteMasterEmMasterTela(Master usuario) {
		MasterTela mt = new MasterTela();
		try { 
			InputStream initialStream =new ByteArrayInputStream(usuario.getFotoPerfil());
				    File targetFile = new File("src/main/resources/static/images/fotoPerfil" + usuario.getIdmaster() + ".tmp");
				    OutputStream outStream = new FileOutputStream(targetFile);
				 
				    byte[] buffer = new byte[8 * 1024];
				    int bytesRead;
				    while ((bytesRead = initialStream.read(buffer)) != -1) {
				        outStream.write(buffer, 0, bytesRead);
				    }
				    IOUtils.closeQuietly(initialStream);
				    IOUtils.closeQuietly(outStream);
	        } catch (Exception e) { 
	           e.printStackTrace(); 
	        }
		mt.setFotoPerfil(new File("images/fotoPerfil" + usuario.getIdmaster() + ".tmp"));
		mt.setNome(usuario.getNome());
		mt.setDescricao(usuario.getDescricao());
		mt.setLinkFb(usuario.getLinkFb());
		mt.setLinkIg(usuario.getLinkIg());
		mt.setTipoUsuario(usuario.getTipoUsuario());
		mt.setEmail(usuario.getEmail());
		return mt;
	}
	
	public MasterTela converteLuthierEmMasterTela(Luthier l) {
		MasterTela mt = new MasterTela();
		try { 
			InputStream initialStream =new ByteArrayInputStream(l.getFotoPerfil());
				    File targetFile = new File("src/main/resources/static/images/fotoPerfil" + l.getIdmaster() + ".tmp");
				    OutputStream outStream = new FileOutputStream(targetFile);
				 
				    byte[] buffer = new byte[8 * 1024];
				    int bytesRead;
				    while ((bytesRead = initialStream.read(buffer)) != -1) {
				        outStream.write(buffer, 0, bytesRead);
				    }
				    IOUtils.closeQuietly(initialStream);
				    IOUtils.closeQuietly(outStream);
	        } catch (Exception e) { 
	           e.printStackTrace(); 
	        }
		mt.setInstrumentos(l.getInstrumentos());
		mt.setFotoPerfil(new File("images/fotoPerfil" + l.getIdmaster() + ".tmp"));
		mt.setNome(l.getNome());
		mt.setDescricao(l.getDescricao());
		mt.setLinkFb(l.getLinkFb());
		mt.setLinkIg(l.getLinkIg());
		mt.setTipoUsuario(l.getTipoUsuario());
		mt.setEmail(l.getEmail());
		return mt;
	}

	public MasterTela converteEstudioEmMasterTela(Estudio es) {
		MasterTela mt = new MasterTela();
		try { 
			InputStream initialStream =new ByteArrayInputStream(es.getFotoPerfil());
				    File targetFile = new File("src/main/resources/static/images/fotoPerfil" + es.getIdmaster() + ".tmp");
				    OutputStream outStream = new FileOutputStream(targetFile);
				 
				    byte[] buffer = new byte[8 * 1024];
				    int bytesRead;
				    while ((bytesRead = initialStream.read(buffer)) != -1) {
				        outStream.write(buffer, 0, bytesRead);
				    }
				    IOUtils.closeQuietly(initialStream);
				    IOUtils.closeQuietly(outStream);
	        } catch (Exception e) { 
	           e.printStackTrace(); 
	        }
		mt.setFotoPerfil(new File("images/fotoPerfil" + es.getIdmaster() + ".tmp"));
		mt.setNome(es.getNome());
		mt.setDescricao(es.getDescricao());
		mt.setLinkFb(es.getLinkFb());
		mt.setLinkIg(es.getLinkIg());
		mt.setTipoUsuario(es.getTipoUsuario());
		mt.setEmail(es.getEmail());
		return mt;
	}


	public MasterTela converteMusicoEmMasterTela(Musico m) {
		MasterTela mt = new MasterTela();
		try { 
			InputStream initialStream =new ByteArrayInputStream(m.getFotoPerfil());
				    File targetFile = new File("src/main/resources/static/images/fotoPerfil" + m.getIdmaster() + ".tmp");
				    OutputStream outStream = new FileOutputStream(targetFile);
				 
				    byte[] buffer = new byte[8 * 1024];
				    int bytesRead;
				    while ((bytesRead = initialStream.read(buffer)) != -1) {
				        outStream.write(buffer, 0, bytesRead);
				    }
				    IOUtils.closeQuietly(initialStream);
				    IOUtils.closeQuietly(outStream);
	        } catch (Exception e) { 
	           e.printStackTrace(); 
	        }
		mt.setInstrumentos(m.getInstrumentos());
		mt.setEstiloMusical(m.getEstiloMusical());
		mt.setFotoPerfil(new File("images/fotoPerfil" + m.getIdmaster() + ".tmp"));
		mt.setNome(m.getNome());
		mt.setDescricao(m.getDescricao());
		mt.setLinkFb(m.getLinkFb());
		mt.setLinkIg(m.getLinkIg());
		mt.setTipoUsuario(m.getTipoUsuario());
		mt.setEmail(m.getEmail());
		return mt;
	}
	
}
