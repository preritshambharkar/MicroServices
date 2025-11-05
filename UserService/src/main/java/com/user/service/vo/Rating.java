package com.user.service.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Rating {

    private String ratingId;
    private String user_id;
    private String carid;
    private int rating;
    private String feedback;
}