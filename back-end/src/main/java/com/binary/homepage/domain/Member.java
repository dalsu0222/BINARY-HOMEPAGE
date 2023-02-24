package com.binary.homepage.domain;

import com.binary.homepage.domain.board.Notice;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    private String name;

    private Integer studentId;

    private String password;

    private boolean enabled;

    private int generation;

    private String gitHub;

    private String notion;

    private String introduce;

    private int warning;

    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "grass_id")
    private Grass grass;

    @OneToMany(mappedBy = "member")
    private List<Notice> notices = new ArrayList<>();

    public void updatePassword(String newPassword) {
        this.password = newPassword;
    }
}
