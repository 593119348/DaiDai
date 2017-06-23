package daidai.lexin.inter;

import java.util.List;

import daidai.lexin.models.Operation;

public interface IOperationFunction {
	public int insertOperation(Operation o);
	public int deleteOperationByID(String id);
	public int deleteOperationByUserID(String id);
	public List<Operation> selectOperationByUserID(String id,int min,int max,String order);
}
