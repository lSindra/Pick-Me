package com.sap.pickme.models;

import org.apache.lucene.analysis.core.LowerCaseFilterFactory;
import org.apache.lucene.analysis.core.WhitespaceTokenizerFactory;
import org.apache.lucene.analysis.ngram.EdgeNGramFilterFactory;
import org.apache.lucene.analysis.snowball.SnowballPorterFilterFactory;
import org.hibernate.search.annotations.*;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.Parameter;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.URL;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Indexed
@Table(name = "RESTAURANT")
@AnalyzerDef(name = "customanalyzer", tokenizer = @TokenizerDef(factory = WhitespaceTokenizerFactory.class), filters = {
        @TokenFilterDef(factory = LowerCaseFilterFactory.class),
        @TokenFilterDef(factory = SnowballPorterFilterFactory.class, params = { @Parameter(name = "language", value = "English") }),
        @TokenFilterDef(factory = EdgeNGramFilterFactory.class, params = { @Parameter(name = "maxGramSize", value = "15") })

})
@AnalyzerDef(name = "customanalyzer_query", tokenizer = @TokenizerDef(factory = WhitespaceTokenizerFactory.class), filters = {
        @TokenFilterDef(factory = LowerCaseFilterFactory.class),
        @TokenFilterDef(factory = SnowballPorterFilterFactory.class, params = { @Parameter(name = "language", value = "English") })

})
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private int id;

    @NotEmpty(message = "Cannot be empty")
    @Column(name = "NAME")
    @Field(index=Index.YES, analyze=Analyze.YES, analyzer = @Analyzer(definition = "customanalyzer"), store=Store.NO)
    private String name;

    @Column(name = "DESCRIPTION")
    @Field(index=Index.YES, analyze=Analyze.YES, analyzer = @Analyzer(definition = "customanalyzer"), store=Store.NO)
    private String description;

    @NotNull
    @Column(name = "PRICE")
    private double price;

    @Column(name = "ALELO")
    private boolean aleloAccepted;

    @Column(name = "LOCATION")
    @Field(index=Index.YES, analyze=Analyze.YES, analyzer = @Analyzer(definition = "customanalyzer"), store=Store.NO)
    private String location;

    @URL
    @Column(name = "IMAGE")
    private String image;

    @Transient
    private int votes;

    //TODO

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() { return price; }

    public void setPrice(double price) { this.price = price; }

    public boolean isAleloAccepted() {
        return aleloAccepted;
    }

    public void setAleloAccepted(boolean aleloAccepted) {
        this.aleloAccepted = aleloAccepted;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getImage() { return image; }

    public void setImage(String image) {
        this.image = image;
    }

    public int getVotes() {
        return votes;
    }

    public void setVotes(int votes) {
        this.votes = votes;
    }
}
