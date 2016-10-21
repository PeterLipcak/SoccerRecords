package cz.muni.fi.pa165.soccerrecords.daos;

import cz.muni.fi.pa165.soccerrecords.entities.Goal;
import java.util.Set;


/**
 * <!-- begin-user-doc -->
 * <!--  end-user-doc  -->
 * @generated
 */
 
public interface IGoalDao 
{	 
	public void create(Goal parameter);	 
	public void delete(Goal parameter) ;
	public Set<Goal> findAll() ;	 
	public Goal findById(long parameter) ;	 
	public void update(Goal parameter) ;
}

