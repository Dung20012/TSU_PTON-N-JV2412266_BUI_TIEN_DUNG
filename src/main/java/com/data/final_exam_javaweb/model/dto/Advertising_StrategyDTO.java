package com.data.final_exam_javaweb.model.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Date;

@Getter
@Setter
public class Advertising_StrategyDTO {
    private int id;

    @NotBlank(message = "Không được để trống")
    private String managerName;

    @NotBlank(message = "Không được để trống")
    @Pattern(regexp = "^(03|09)\\d{8}$", message = "Số điện thoại phải bắt đầu bằng 03 hoặc 09 và có 11 chữ số")
    private String managerPhone;

    @NotBlank(message = "Khong được để trống")
    private String staffName;

    @Pattern(regexp = "^(03|09)\\d{8}$", message = "Số điện thoại phải bắt đầu bằng 03 hoặc 09 và có 11 chữ số")
    @NotBlank(message = "Không được để trống")
    private String staffPhone;

    @NotNull(message = "Không được để trống")
    private Date implementDate;

    @NotNull(message = "Không được để trống")
    private int dayDuration;

    @NotNull(message = "Không được để trống")
    private String imageURL;

    @NotBlank(message = "Không được để trống")
    private String content;
}
