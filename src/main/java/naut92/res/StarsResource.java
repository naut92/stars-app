package naut92.res;

import naut92.entities.AstronomersEntity;
import naut92.entities.StarsEntity;
import naut92.impl.AstronomersServiceImpl;
import naut92.impl.StarsServiceImpl;
import naut92.mappers.StarsEntityMapper;
import naut92.util.Color;
import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.List;

@Path("/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class StarsResource {

    SqlSessionFactory sqlSessionFactory;
    StarsServiceImpl starsService = new StarsServiceImpl(sqlSessionFactory);
    AstronomersServiceImpl astronomersService = new AstronomersServiceImpl(sqlSessionFactory);
    //@Inject
    //StarsEntityMapper starsService;

    @GET
    @Path("/stars")
    public Response listStars() {
        List<StarsEntity> stars = starsService.getStarsWithAstronomerName();
        System.out.println(Color.MAGENTA + "all stars call: " + stars + Color.RESET);
        return Response.ok(new GenericEntity<List<StarsEntity>>(stars){}).build();
    }

    @GET
    @Path("/star/{starId}")
    public Response getStarById(@PathParam(value = "starId") Long starId) {
        StarsEntity star = starsService.getStarById(starId);
        if(star == null){
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        System.out.println(Color.GREEN + "star call: " + star + Color.RESET);
        return Response.ok(star).build();
    }
//*
    @GET
    @Path("star/{starId}/astronomer_id")
    public Response getAnimalById(@PathParam(value = "starId") Long starId){
        StarsEntity star = starsService.getStarById(starId);
        if(star == null){
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        List<AstronomersEntity> astronomers = astronomersService.getAstronomers();
        System.out.println(Color.BLUE + "all astronomers call: " + astronomers + Color.RESET);
        return Response.ok(new GenericEntity<List<AstronomersEntity>>(astronomers){}).build();
    }
/*
    @POST
    public Response createAnimal (AnimalsEntity animal,
                                  @Context UriInfo uriInfo
    ) {
        animalService.save(animal);
        Long id = animal.getId();

        URI createdUri = uriInfo.getAbsolutePathBuilder().path(Long.toString(id)).build();
        System.out.println(uriInfo);
        return Response.created(createdUri).entity(animal.getId()).build();
    }

    @PUT
    @Path("{id}")
    public Response updateAnimal(@PathParam("id") Long id,
                                 AnimalsEntity animal){
        AnimalsEntity existAnimal = animalService.findOne(id);
        if (existAnimal == null){
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        else {
            existAnimal.setAnimalname(animal.getAnimalname());
            existAnimal.setDateborn(animal.getDateborn());
            existAnimal.setSex(animal.getSex());
            existAnimal.setCustomersId(animal.getCustomersId());
            existAnimal.setTypesanimalsId(animal.getTypesanimalsId());
            animalService.update(animal);
        }
        return Response.noContent().build();
    }
    /*
        @DELETE
        @Path("{id}")
        public Response deleteAnimal(@PathParam("id") Long id){
            AnimalsEntity existAnimal = animalService.findOne(id);
            if (existAnimal == null){
                throw new WebApplicationException(Response.Status.NOT_FOUND);
            }
            animalService.delete(existAnimal);
            AnimalsEntity animalEx = animalService.findOne(id);
            if(animalEx != null) {
                System.out.println(animalEx.toString());
            }
            return Response.ok().build();
        }

    */
/*
    @DELETE
    @Path("{id}")
    public void deleteAnimal(@PathParam("id") Long id, InputStream in){
        AnimalsEntity animal = readAnimal(in);
        //  System.out.println(animal.toString());
        System.out.println(animal.getId());

        AnimalsEntity inDb = animalService.findOne(id);
        System.out.println(inDb.toString());

        animalService.delete(id);
        AnimalsEntity animalEx = animalService.findOne(id);
        System.out.println(animalEx.getAnimalname());
        //Long id = animal.getId();
        //System.out.println(id);
        //URI createdUri = uriInfo.getAbsolutePathBuilder().path(Long.toString(id)).build();
        //return Response.created(createdUri).build();
    }


    protected AnimalsEntity readAnimal(InputStream in) {
        ObjectMapper mapper = new ObjectMapper();
        AnimalsEntity animal = new AnimalsEntity();
        try {
            animal = mapper.readValue(in, AnimalsEntity.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return animal;
    }*/
}
