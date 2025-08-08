package com.data.final_exam_javaweb.controller;

import com.data.final_exam_javaweb.model.dto.Advertising_StrategyDTO;
import com.data.final_exam_javaweb.model.entity.Advertising_Strategy;
import com.data.final_exam_javaweb.service.IAdvertisingStrategyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.Date;
import java.time.LocalDate;

@Controller
@RequestMapping("/adv")
public class AdvertisingStrategyController {
    @Autowired
    private IAdvertisingStrategyService advertisingStrategyService;

    // Hiển thị danh sách, tìm kiếm, phân trang
    @GetMapping
    public String showAll(@RequestParam(value = "page", defaultValue = "1") int page,
                          @RequestParam(value = "size", defaultValue = "3") int size,
                          @RequestParam(value = "keyword", required = false) String keyword,
                          Model model) {
        if (keyword != null && !keyword.trim().isEmpty()) {
            model.addAttribute("adv", advertisingStrategyService.searchByName(keyword));
        }else {
            int totalProduct = advertisingStrategyService.count();
            int totalPage = (int) Math.ceil((double) totalProduct / size);

            model.addAttribute("adv", advertisingStrategyService.findByPage(page, size));
            model.addAttribute("currentPage", page);
            model.addAttribute("totalPage", totalPage);
        }
        return "list";
    }

    // Hiển thị form thêm mới
    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("advertisingStrategy",new Advertising_Strategy());
        return "add";
    }

    // Xử lý form thêm mới
    @PostMapping("/save")
    public String save(@Valid @ModelAttribute("advertisingStrategy")Advertising_StrategyDTO dto,
                       BindingResult result) {
        if (result.hasErrors()) {
            return "add";
        }
        // Map DTO -> Entity
        Advertising_Strategy adv = new Advertising_Strategy();
        adv.setManagerName(dto.getManagerName());
        adv.setManagerPhone(dto.getManagerPhone());
        adv.setStaffName(dto.getStaffName());
        adv.setStaffPhone(dto.getStaffPhone());
        adv.setImplementDate(Date.valueOf(LocalDate.now()));
        adv.setDayDuration(dto.getDayDuration());
        adv.setImageUrl(dto.getImageURL());
        adv.setContent(dto.getContent());

        advertisingStrategyService.save(adv);
        return "redirect:/adv";
    }

    // Hiển thị form update
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") int id, Model model) {
        model.addAttribute("advertisingStrategy",advertisingStrategyService.findById(id));
        return "edit";
    }

    // Xử lí form update
    @PostMapping("/update")
    public String update(@Valid @ModelAttribute("advertisingStrategy") Advertising_StrategyDTO dto,
                         BindingResult result) {
        if (result.hasErrors()) {
            return "edit";
        }
        // Map DTO -> Entity
        Advertising_Strategy adv = new Advertising_Strategy();
        adv.setId(dto.getId());
        adv.setManagerPhone(dto.getManagerPhone());
        adv.setStaffName(dto.getStaffName());
        adv.setStaffPhone(dto.getStaffPhone());
        adv.setImplementDate(Date.valueOf(LocalDate.now()));
        adv.setDayDuration(dto.getDayDuration());
        adv.setContent(dto.getContent());

        advertisingStrategyService.update(adv);
        return "redirect:/adv";
    }

    // Xóa
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id) {
        advertisingStrategyService.delete(id);
        return "redirect:/adv";
    }
}
