package com.taoleg.servercore.common.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="agent_img")
public class AgentImgEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer appid;

    @Column(name = "imgurl")
    private String imgUrl;//图片路径

    @Column(name = "positionx")
    private Integer positionX;//背景图x坐标

    @Column(name = "positiony")
    private Integer positionY;//背景图Y坐标

    @Column(name = "length")
    private Integer length;//二维码边长

    @Column(name = "tags")
    private String tags;//图片所在的路径

    @Column(name = "state")
    private String state;//图片的状态

}
