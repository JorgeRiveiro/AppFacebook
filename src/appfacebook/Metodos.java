/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appfacebook;

import facebook4j.Comment;
import facebook4j.*;
import facebook4j.FacebookException;
import facebook4j.FacebookFactory;
import facebook4j.ResponseList;
import facebook4j.conf.ConfigurationBuilder;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author JorgePc
 */
public class Metodos {
    
    static Facebook facebook;
/**
 * acceso mediante tokens
 */
    public void acceso() {
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthAppId("1903123226597689")
                .setOAuthAppSecret("831f5ca4ae32096ccd8452ad19a23c14")
                .setOAuthAccessToken("EAACEdEose0cBAOV7bzVHJ7AHySJJEfULDUbI0ZB32DLcjyplEYuMwfmaTLD34AsGVokOXsDhZC4Udk5VXbkn4OGAOj9FbRJnru0sC93LFVDZC865Ih18Wb7ZBegnoOGqSop1se1PgZBZB3vNNcqHPahcT2IJiDhZCa0Inv5I7iErRtEUT8O1CzFID5qv1rgPWj80zo0WKZAZBUQZDZD")
                .setOAuthPermissions("email,publish_stream,...");
        FacebookFactory ff = new FacebookFactory(cb.build());
        facebook = ff.getInstance();
    }
/**
 * postear estado
 * @param post texto que queres postear
 */
    public void publicar(String post) {
        try {
            facebook.postStatusMessage(post);
        } catch (FacebookException ex) {
            System.out.println("error 1" + ex.getMessage());
        }
    }

    
    /**
     * publicar unha foto
     */
    public void postFoto(){
        try {
            PostUpdate post = null;
            try {
                post = new PostUpdate(new URL("http://facebook4j.org"))
                    .picture(new URL("http://facebook4j.org/images/hero.png"))
                    .name("Facebook4J - A Java library for the Facebook Graph API")
                    .caption("facebook4j.org")
                    .description("Facebook4J is a Java library for the Facebook Graph API.");
facebook.postFeed(post);
            } catch (MalformedURLException ex) {
                Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
            }
            facebook.postFeed(post);
        } catch (FacebookException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /** 
     * facer comentario
     * @param comment texto que queres postear
     */
    public void comentarioFoto(String comment){
        try {
            facebook.commentPhoto(" ", comment);
        } catch (FacebookException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
     * busca comentarios en unha publicación
     * @param buscar a buscar na publicacion
     */
    public void buscarComentarios(String buscar){
        try {
            ResponseList<Group> results = facebook.searchGroups(buscar);
            for(int i=0;i<results.size();i++)
                System.out.println(results.get(i));
        } catch (FacebookException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
     * comentarios de unha publicacion
     */
    public void commentPublicacion(){
        try {
           ResponseList<Comment> results = facebook.getCommentReplies("1000");
             for(int i=0;i<results.size();i++)
                System.out.println(results.get(i));
        } catch (FacebookException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
