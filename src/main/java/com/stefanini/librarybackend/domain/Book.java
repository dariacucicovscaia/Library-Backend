package com.stefanini.librarybackend.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "book")
public class Book implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bookId_generator")
    @SequenceGenerator(name = "bookId_generator", allocationSize = 1)
    @Column(name = "id")
    private int id;
    @Column(name = "title")
    private String title;
    @Column(name = "bookDescription")
    private String description;
    @Column(name = "shelfNumber")
    private String shelfNumber;
    @Column(name = "bookStatus")
    private String status;
    @Column(name = "createdOn")
    private Date createdOn;

      @ManyToOne
     @JoinColumn(name = "user_id")
    private User user;
      @ManyToMany(mappedBy = "category", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
      private Set<Category> categories = new HashSet<Category>();
       @ManyToMany(cascade = CascadeType.PERSIST, CascadeType.MERGE)
     private Set<Author> authors = new HashSet<Author>();
       @OneToMany(mappedBy = "history", cascade = CascadeType.All, fetch = FetchType.EAGER)
     private Set<History> history = new HashSet<History>();

    /**
     * Class constructor.
     */
    public Book() {
    };

    /**
     * Class constructor with @param firstName, lastName, userName
     */
    public Book (int id, String title, String description, String shelfNumber, String status, Date createdOn) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.shelfNumber = shelfNumber;
        this.status = status;
        this.createdOn = createdOn;
    }
    public Book (String title, String description, String shelfNumber, String status, Date createdOn) {
        this.title = title;
        this.description = description;
        this.shelfNumber = shelfNumber;
        this.status = status;
        this.createdOn = createdOn;
    }
    public Book (String title, String description, String shelfNumber) {
        this.title = title;
        this.description = description;
        this.shelfNumber = shelfNumber;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getShelfNumber() {
        return shelfNumber;
    }

    public void setShelfNumber(String shelfNumber) {
        this.shelfNumber = shelfNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }
   public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Category> getCategoryList() {
		return categories;
	}

	public void setCategoryList(Set<Task> categories) {
		this.categories = categories;
	}

	public Set<History> getHistoryList() {
		return history;
	}

	public void setHistoryList(Set<History> history) {
        this.history = history;

        public Set<Author> getAuthorList () {
            return author;
        }

        public void setAuthorList (Set < Author > author) {
            this.author = author;
        }
    }

}