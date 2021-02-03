package myrestapis;

import java.util.ArrayList;

import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import mybeans.Celebrity;
import mybeans.CelebrityOperations;

@Path("/celeb")
public class RestServices 
{
	
	Celebrity obj;
	CelebrityOperations cop;
	
	public RestServices()
	{
		
	}
	
	
	//http://localhost:8080/RA_CelebrityProject/api/celeb/all
	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Celebrity> getCelebrities()
	{
		cop=new CelebrityOperations();
		ArrayList<Celebrity> list;
		list=cop.getAllCelebrities();
		return(list);
	}

	
	//http://localhost:8080/RA_CelebrityProject/api/celeb/13
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Celebrity getCelebrity(@PathParam("id") int id)
	{
		cop=new CelebrityOperations();
		obj=cop.searchInfo(id);
		return(obj);
	}
	
	@POST
	@Path("/addceleb")
	@Produces(MediaType.TEXT_PLAIN)
	public String addCelebrity(@FormParam("cnm") String nm,@FormParam("field") String fld,@FormParam("coun") String co)
	{
		obj=new Celebrity();
		obj.setCelebnm(nm);
		obj.setField(fld);
		obj.setCountry(co);
		cop=new CelebrityOperations();
		return cop.addNewCelebrity(obj);
	}
	
	@DELETE
	@Path("/del/{id}")
	@Produces(MediaType.TEXT_PLAIN)
	public String delPlayer(@PathParam("id") int id)
	{
		String delstat="";
		cop=new CelebrityOperations();
		delstat=cop.deleteCelebrity(id);
		
		return(delstat);
	}
	
	@PUT
	@Path("/change")
	@Produces(MediaType.TEXT_PLAIN)
	public String changeCeleb(@FormParam("id") int no, @FormParam("country") String co)
	{
		String updstat="";
		
		return(updstat);
	}
	

}









