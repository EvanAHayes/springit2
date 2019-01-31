package com.ehayes.springit2.Springitmodel;


import com.ehayes.springit2.Service.BeanUtil;
import lombok.*;
import org.hibernate.validator.constraints.URL;
import org.ocpsoft.prettytime.PrettyTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@RequiredArgsConstructor
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Link extends Auditable {

    @Id
    @GeneratedValue
    private long id;

    @NonNull
    @NotEmpty(message = "Please enter a title")
    private String title;

    @NonNull
    @NotEmpty(message = "Please enter a url")
    @URL(message = "please enter a valid url")
    private String url;

//    public long getId() {
//        return id;
//    }
//
//    public void setId(long id) {
//        this.id = id;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public String getUrl() {
//        return url;
//    }
//
//    public void setUrl(String url) {
//        this.url = url;
//    }

//comments

    //when display a link may have comments on link display some comments about the link
    //one link to many comments map one to many
    @OneToMany(mappedBy = "link")
    private List<Comment> comments = new ArrayList<>();


    public void addComment(Comment comment){
        comments.add(comment);
    }

    //use to get url of someone post and get domain name
    public String getDomainName() throws URISyntaxException {
        URI uri = new URI(this.url);
        String domain = uri.getHost();
        return domain.startsWith("www.") ? domain.substring(4) : domain;
    }

//get pretty time need a date object
    public String getPrettyTime() {
        PrettyTime pt = BeanUtil.getBean(PrettyTime.class);
        return pt.format(convertToDateViaInstant(getCreationDate()));
    }

    private Date convertToDateViaInstant(LocalDateTime dateToConvert) {
        return java.util.Date.from(dateToConvert.atZone(ZoneId.systemDefault()).toInstant());
    }


}
