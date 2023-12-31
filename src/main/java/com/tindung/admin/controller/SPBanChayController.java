package com.tindung.admin.controller;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tindung.repository.categorysRepository;
import com.tindung.repository.productsRepository;

@Controller
@RequestMapping("admin")
public class SPBanChayController {
    @Autowired
    productsRepository spdao;

    @Autowired
    categorysRepository cdao;

    @RequestMapping("/spbanchay")
    public String spbc(Model model, @RequestParam(name = "thang", required = false) Integer thang,

            @RequestParam(name = "ngay", required = false) String ngay) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sdf2 = new SimpleDateFormat("dd-MM-yyyy");
        model.addAttribute("listspbc", spdao.findBestSellingProducts());
        List<Object[]> listspbc = spdao.findBestSellingProducts();
        Double tongtien = 0.0;
        for (Object[] item : listspbc) {
            tongtien += Double.parseDouble(item[2].toString()) *
                    Double.parseDouble(item[3].toString());
        }
        model.addAttribute("tongcong", tongtien);
        model.addAttribute("listsptc", spdao.findLostSellingProducts());
        model.addAttribute("listlsp", cdao.findAll());
        System.out.println("Tháng 1 " + thang);
        if (ngay != null && !ngay.isEmpty()) {
            try {
                Date selectedDate = sdf.parse(ngay);
                // Gọi phương thức findProductsSoldOnDate với ngày thích hợp
                model.addAttribute("listspbctheongay", spdao.findProductsSoldOnDate(selectedDate));
                List<Object[]> listspbctn = spdao.findProductsSoldOnDate(selectedDate);
                Double tongtientn = 0.0;
                for (Object[] item : listspbctn) {
                    tongtientn += Double.parseDouble(item[3].toString()) *
                            Double.parseDouble(item[2].toString());
                }
                model.addAttribute("tongcongtn", tongtientn);
                String formattedDate1 = sdf2.format(selectedDate);
                model.addAttribute("ngay1", formattedDate1);
                System.out.println("Ngày1 : " + ngay);
                System.out.println(spdao.findProductsSoldOnDate(selectedDate));
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            try {
                // ngay = sdf.format(new Date());
                Date currentDate = new Date(); // Lấy ngày hiện tại
                String HomNay = sdf.format(currentDate);
                Date selectedDate1 = sdf.parse(HomNay);
                model.addAttribute("listspbctheongay", spdao.findProductsSoldOnDate(selectedDate1));
                System.out.println(spdao.findProductsSoldOnDate(selectedDate1));
                String formattedDate = sdf2.format(currentDate);
                model.addAttribute("ngay2", formattedDate);
                System.out.println("Ngày2 : " + ngay);
                // System.out.println(spdao.findProductsSoldOnDate(selectedDate2));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (thang != null) {
            // Đã chọn tháng, thực hiện xử lý
            System.out.println("Tháng: " + thang);
            // Gọi phương thức findBestSellingProducts với tháng thích hợp
            model.addAttribute("listspbctheomonth", spdao.findBestSellingProductsMonth(thang));
            List<Object[]> listspbctt = spdao.findBestSellingProductsMonth(thang);
            Double tongtientt = 0.0;
            for (Object[] item : listspbctt) {
                tongtientt += Double.parseDouble(item[3].toString()) *
                        Double.parseDouble(item[2].toString());
            }
            model.addAttribute("tongcongtt", tongtientt);
            model.addAttribute("thang1", thang);
        } else {
            // Lấy ngày hôm nay
            LocalDate ngayHomNay = LocalDate.now();
            // Lấy tháng của ngày hôm nay
            int thangHomNay = ngayHomNay.getMonthValue();
            System.out.println("Tháng hôm nay: " + thangHomNay);
            model.addAttribute("listspbctheomonth", spdao.findBestSellingProductsMonth(thangHomNay));
            model.addAttribute("thangHomNay", thangHomNay);
            List<Object[]> listspbctt = spdao.findBestSellingProductsMonth(thangHomNay);
            Double tongtientt = 0.0;
            for (Object[] item : listspbctt) {
                tongtientt += Double.parseDouble(item[3].toString()) *
                        Double.parseDouble(item[2].toString());
            }
            model.addAttribute("tongcongtt", tongtientt);
            // Hiển thị trang ban đầu (chưa chọn tháng)
            model.addAttribute("listspbc", spdao.findBestSellingProducts()); // Hoặc gán
            // giá trị mặc định khác
        }
        return "admin/view/spbanchay";
    }

    @RequestMapping("/spbanchay/category")
    public String spbcbycategory(Model model, @RequestParam(name = "thang", required = false) Integer thang,
            @RequestParam(name = "ngay", required = false) String ngay,
            @RequestParam("categoryid") int categoryid) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sdf2 = new SimpleDateFormat("dd-MM-yyyy");
        model.addAttribute("listlsp", cdao.findAll());
        model.addAttribute("listspbc", spdao.findBestSellingProductsByCategory(categoryid));
        List<Object[]> listspbc = spdao.findBestSellingProductsByCategory(categoryid);
        Double tongtien = 0.0;
        for (Object[] item : listspbc) {
            tongtien += Double.parseDouble(item[2].toString()) *
                    Double.parseDouble(item[3].toString());
        }
        model.addAttribute("tongcong", tongtien);
        model.addAttribute("listsptc", spdao.findLostSellingProductsByCategory(categoryid));
        if (ngay != null && !ngay.isEmpty()) {
            try {
                Date selectedDate = sdf.parse(ngay);
                // Gọi phương thức findProductsSoldOnDate với ngày thích hợp
                model.addAttribute("listspbctheongay", spdao.findProductsSoldOnDate(selectedDate));
                String formattedDate1 = sdf2.format(selectedDate);
                model.addAttribute("ngay1", formattedDate1);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            try {

                Date currentDate = new Date(); // Lấy ngày hiện tại
                String HomNay = sdf.format(currentDate);
                Date selectedDate1 = sdf.parse(HomNay);
                model.addAttribute("listspbctheongay", spdao.findProductsSoldOnDate(selectedDate1));
                System.out.println(spdao.findProductsSoldOnDate(selectedDate1));
                String formattedDate = sdf2.format(currentDate);
                model.addAttribute("ngay2", formattedDate);
                System.out.println("Ngày2 : " + ngay);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (thang != null) {
            // Đã chọn tháng, thực hiện xử lý
            System.out.println("Tháng: " + thang);
            // Gọi phương thức findBestSellingProducts với tháng thích hợp
            model.addAttribute("listspbctheomonth", spdao.findBestSellingProductsMonth(thang));
            model.addAttribute("thang1", thang);
        } else {
            // Lấy ngày hôm nay
            LocalDate ngayHomNay = LocalDate.now();
            // Lấy tháng của ngày hôm nay
            int thangHomNay = ngayHomNay.getMonthValue();
            System.out.println("Tháng hôm nay: " + thangHomNay);
            model.addAttribute("listspbctheomonth", spdao.findBestSellingProductsMonth(thangHomNay));
            model.addAttribute("thangHomNay", thangHomNay);
        }
        return "admin/view/spbanchay";
    }

}
