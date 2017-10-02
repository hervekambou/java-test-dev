package org.gestion.bp.metier;

import java.util.Date;
import java.util.List;

import org.gestion.bp.dao.IBanqueDao;
import org.gestion.bp.entities.Client;
import org.gestion.bp.entities.Compte;
import org.gestion.bp.entities.Employe;
import org.gestion.bp.entities.Groupe;
import org.gestion.bp.entities.Operation;
import org.gestion.bp.entities.Retrait;
import org.gestion.bp.entities.Versement;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class BanqueMetierImpl implements IBanqueMetier {
 
	private IBanqueDao dao;
	
	public void setDao(IBanqueDao dao) {
		this.dao = dao;
	}

	@Override
	public Client addClient(Client c) {
		return dao.addClient(c);
	}

	@Override
	public Employe addEmploye(Employe e, Long codesup) {
		return dao.addEmploye(e, codesup);
	}

	@Override
	public Groupe addGroupe(Groupe g) {
		return dao.addGroupe(g);
	}

	@Override
	public void addEmployeToGroupe(Long codeEmp, Long codeGr) {
		dao.addEmployeToGroupe(codeEmp, codeGr);
	}

	@Override
	public Compte addCompte(Compte cp, Long codeCli, Long codeEmp) {
		return dao.addCompte(cp, codeCli, codeEmp);
	}

	@Override
	public void verser(double mt, String cpte, Long codeEmp) {
		dao.addOperation(new Versement(new Date(), mt), cpte, codeEmp);
		Compte cp = dao.consulterCompte(cpte);
		cp.setSolde(cp.getSolde()+mt);
	}

	@Override
	public void retirer(double mt, String cpte, Long codeEmp) {
		dao.addOperation(new Retrait(new Date(), mt), cpte, codeEmp);
		Compte cp = dao.consulterCompte(cpte);
		cp.setSolde(cp.getSolde()-mt);
	}

	@Override
	public void virement(double mt, String cpte1, String cpte2, Long codeEmp) {
		retirer(mt,cpte1,codeEmp);
		verser(mt,cpte2,codeEmp);
	}

	@Override
	public Compte consulterCompte(String codeCpte) {
		return dao.consulterCompte(codeCpte);
	}

	@Override
	public List<Operation> consulterOperations(String codeCpte) {
		return dao.consulterOperations(codeCpte);
	}

	@Override
	public Client consulterClient(Long codeCli) {
		return dao.consulterClient(codeCli);
	}

	@Override
	public List<Client> consulterClients(String mc) {
		return dao.consulterClients(mc);
	}

	@Override
	public List<Compte> getComptesByClient(Long codeCli) {
		return dao.getComptesByClient(codeCli);
	}

	@Override
	public List<Compte> getComptesByEmploye(Long codeEmp) {
		return dao.getComptesByEmploye(codeEmp);
	}

	@Override
	public List<Employe> getEmployes() {
		return dao.getEmployes();
	}

	@Override
	public List<Groupe> getGroupes() {
		return dao.getGroupes();
	}

	@Override
	public List<Employe> getEmployesByGroupe(Long codeGr) {
		return dao.getEmployesByGroupe(codeGr);
	}

}
