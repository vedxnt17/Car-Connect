package dao;

import java.io.FileNotFoundException;
import java.io.IOException;

import entity.model.Admin;
import exception.DatabaseConnectionException;
import exception.InvalidInputException;

public interface IAdminService {

	public Admin getAdminById(int adminId)  throws FileNotFoundException, ClassNotFoundException, IOException, InvalidInputException;
	public Admin getAdminByUsername(String Username) throws InvalidInputException, FileNotFoundException, ClassNotFoundException, IOException;
	public void registerAdmin(Admin admin);
	public void updateAdmin(Admin admin) throws InvalidInputException, DatabaseConnectionException, FileNotFoundException;
	public void deleteAdmin(int adminId);
}
