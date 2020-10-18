package com.dextra.challange.MarvelBackend.domain.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@NamedQueries({ 
	@NamedQuery(name = "Comic.Find_Comics",
			query = "select c from Character c "
					+ "left join fetch c.comics cm "
					+ "where c.id = ?1 ")
})
@Entity
public class Character implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter
	@Setter
	private Integer id;

	@Getter
	@Setter
	private String name;

	@Getter
	@Setter
	private String description;

	@Getter
	@Setter
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private Date modified;

	@Getter
	@Setter
	private String resourceURI;

	@JsonIgnore
	@ManyToMany
	@JoinTable(		
			name = "CHARACTER_URL", 
			joinColumns = @JoinColumn(name = "character_id"),
			inverseJoinColumns = @JoinColumn(name = "url_id")
		)
	private List<Url> urls= new ArrayList<>(); 

	@Getter
	@Setter
	private String thumbnail;

	@JsonIgnore
	@ManyToMany
	@JoinTable(		
			name = "CHARACTER_COMIC", 
			joinColumns = @JoinColumn(name = "character_id"),
			inverseJoinColumns = @JoinColumn(name = "comic_id")
		)
	private List<Comic> comics = new ArrayList<>();
	
	@OneToMany(mappedBy = "character", cascade = CascadeType.ALL)
	private List<Event> events = new ArrayList<>();
	
	@JsonIgnore
	@ManyToMany
	@JoinTable(		
			name = "CHARACTER_SERIE", 
			joinColumns = @JoinColumn(name = "character_id"),
			inverseJoinColumns = @JoinColumn(name = "serie_id")
		)
	private List<Serie> series = new ArrayList<>();
	
	@JsonIgnore
	@ManyToMany
	@JoinTable(		
			name = "CHARACTER_HISTORY", 
			joinColumns = @JoinColumn(name = "character_id"),
			inverseJoinColumns = @JoinColumn(name = "history_id")
		)
	private List<History> histories = new ArrayList<>();

	public Character() {

	}

	public Character(String name, String description, Date modified, String resourceURI, String thumbnail) {
		this.name = name;
		this.description = description;
		this.modified = modified;
		this.resourceURI = resourceURI;
		this.thumbnail = thumbnail;
	}
	
	public void addUrl(Url url) {
		this.urls.add(url);
	}
	
	public void addComic(Comic comic) {
		this.comics.add(comic);
	}
	
	public void addSerie(Serie serie) {
		this.series.add(serie);
	}
	
	public void addEvent(Event event) {
		this.events.add(event);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Character other = (Character) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}