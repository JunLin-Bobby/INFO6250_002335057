/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/SpringFramework/AbstractController.java to edit this template
 */
package com.mycompany.ass4part4.controller;

import com.mycompany.ass4part4.model.Movie;
import com.mycompany.ass4part4.movieDAO;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 *
 * @author bobby
 */
public class MovieController extends AbstractController {
    
    private movieDAO movieDAO = new movieDAO();
    public MovieController() {
    }
    
    protected ModelAndView handleRequestInternal(
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
       
        String action =request.getParameter("action");
        System.out.println(action);
        if (action.equals("addMovie")) {
            return new ModelAndView("addMovie"); 
        }else if (action.equals("searchMovie")) {
            return new ModelAndView("SearchMovie"); 
         // from the hidden url in addMovie.jsp's Form   
        }else if(action.equals("addMovieSubmit")){
            String title = request.getParameter("title");
            String actor = request.getParameter("actor");
            String actress = request.getParameter("actress");
            String genre = request.getParameter("genre");
            int year = Integer.parseInt(request.getParameter("year"));
            
            Movie movie = new Movie(title, actor, actress, genre, year);
            boolean success = movieDAO.addMovie(movie);
            
            if (success) {
                return new ModelAndView("success");
            } else {
                return new ModelAndView("addMovie", "message", "Error adding movie.");
            }
            
        }else if(action.equals("searchMovieSubmit")){
            String category = request.getParameter("category");
            String keyword = request.getParameter("keyword");
            
            List<Movie> movies= movieDAO.searchMovies(category, keyword);
            for(Movie m:movies){
                m.toString();
            }
            ModelAndView mav = new ModelAndView("searchResult");
            mav.addObject("movies",movies);
            return mav; 
                
        }
        
         return new ModelAndView("home");
    }
    
}
