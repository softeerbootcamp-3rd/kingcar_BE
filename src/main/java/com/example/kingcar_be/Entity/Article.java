package com.example.kingcar_be.Entity;

import com.example.kingcar_be.DTO.MasterNotice;
import jakarta.persistence.*;
import lombok.Getter;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Article {
    public Article(String title, int price, String contents, String imgUrl, Course course, Member writer){
        this.title=title;
        this.price=price;
        this.contents=contents;
        this.image=imgUrl;
        this.course=course;
        this.writer=writer;
    }

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "article_id")
    private Long articleId;

    @OneToMany(mappedBy = "article", fetch = FetchType.LAZY)
    private List<Request> requests;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;  //글쓰이

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member writer;


    @NotNull
    @Column(name = "title")
    private String title;

    @NotNull
    private String image;

    @NotNull
    private int price;

    @NotNull
    private String contents;

    @NotNull
    private boolean connection;

    public void isConnected(){
        this.connection=true;
    }

    public MasterNotice toMasterNotice(String winnerNickname){
        return MasterNotice.builder()
                .articleId(this.getArticleId())
                .carBrand(this.writer.getCarBrand())
                .carModel(this.writer.getCarModel())
                .winnerNickname(winnerNickname)
                .build();

    }
}
