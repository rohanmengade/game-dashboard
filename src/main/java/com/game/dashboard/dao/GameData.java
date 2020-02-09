package com.game.dashboard.dao;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.opencsv.bean.CsvBindByName;
import lombok.*;

import javax.persistence.*;


@Entity
@Data
@Builder
@Table( name = "game_data" )
@JsonInclude( Include.NON_EMPTY )
@AllArgsConstructor
@NoArgsConstructor
public class GameData {

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    private int id;

    @CsvBindByName
    private String gameName;

    @CsvBindByName
    private String intensity;

    @CsvBindByName
    private String product;

    @CsvBindByName
    private String tier;

    @CsvBindByName
    private String category;

    @CsvBindByName
    private String subCategory;

    @CsvBindByName
    private String vendor;

    @Column( columnDefinition = "TEXT" )
    @CsvBindByName
    private String techDescription;

    @CsvBindByName
    private String platform;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public String getIntensity() {
        return intensity;
    }

    public void setIntensity(String intensity) {
        this.intensity = intensity;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getTier() {
        return tier;
    }

    public void setTier(String tier) {
        this.tier = tier;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(String subCategory) {
        this.subCategory = subCategory;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getTechDescription() {
        return techDescription;
    }

    public void setTechDescription(String techDescription) {
        this.techDescription = techDescription;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }


}
