package com.flashsolution.lumierebeauty.entity;
import jakarta.persistence.*;

    @Entity 
    @Table(name = "brands")
    public class Brand {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String name;

        private String imageUrl;

        private String description;
        // Constructors, getters, and setters
        public Brand() {
        }
        public Long getId() {
            return id;
        }
        public void setId(Long id) {
            this.id = id;       
        }
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public String getImageUrl() {
            return imageUrl;
        }
        public void setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
        }
        public String getDescription() {
            return description;
        }
        public void setDescription(String description) {
            this.description = description;
        }

    }   
