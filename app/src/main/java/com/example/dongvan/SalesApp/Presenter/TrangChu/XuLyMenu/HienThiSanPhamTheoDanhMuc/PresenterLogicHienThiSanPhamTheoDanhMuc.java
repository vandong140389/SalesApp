package com.example.dongvan.SalesApp.Presenter.TrangChu.XuLyMenu.HienThiSanPhamTheoDanhMuc;

import android.view.View;
import android.widget.ProgressBar;

import com.example.dongvan.SalesApp.Model.HienThiSanPhamTheoDanhMuc.ModelHienThiSanPhamTheoDanhMuc;
import com.example.dongvan.SalesApp.Model.ObjectClass.SanPham;
import com.example.dongvan.SalesApp.UIView.HienThiSanPhamTheoDanhMuc.ViewHienThiSanPhamTheoDanhMuc;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by VoNga on 04-Apr-17.
 */

public class PresenterLogicHienThiSanPhamTheoDanhMuc implements IPresenterHienThiSanPhamTheoDanhMuc {
    ViewHienThiSanPhamTheoDanhMuc viewHienThiSanPhamTheoDanhMuc;
    ModelHienThiSanPhamTheoDanhMuc modelHienThiSanPhamTheoDanhMuc;

    public  PresenterLogicHienThiSanPhamTheoDanhMuc(ViewHienThiSanPhamTheoDanhMuc viewHienThiSanPhamTheoDanhMuc){

        this.viewHienThiSanPhamTheoDanhMuc = viewHienThiSanPhamTheoDanhMuc;
        modelHienThiSanPhamTheoDanhMuc = new ModelHienThiSanPhamTheoDanhMuc();
    }

    @Override
    public void LayDanhSachSanPhamTheoMaLoai(int masp, boolean kiemtra) {
        List<SanPham> sanPhamList = new ArrayList<>();
        if(kiemtra){
            sanPhamList = modelHienThiSanPhamTheoDanhMuc.LayDanhSachSanPhamTheoMaLoai(masp,"DANHSACHSANPHAM","LayDanhSachSanPhamTheoMaThuongHieu",0);
        }else{
            sanPhamList = modelHienThiSanPhamTheoDanhMuc.LayDanhSachSanPhamTheoMaLoai(masp,"DANHSACHSANPHAM","LayDanhSachSanPhamTheoMaLoaiDanhMuc",0);
        }

        if(sanPhamList.size() > 0){
            viewHienThiSanPhamTheoDanhMuc.HienThiDanhSachSanPham(sanPhamList);
        }else{
            viewHienThiSanPhamTheoDanhMuc.LoiHienThiDanhSachSanPham();
        }

    }

    public List<SanPham> LayDanhSachSanPhamTheoMaLoaiLoadMore(int masp, boolean kiemtra, int limit, ProgressBar progressBar){
        progressBar.setVisibility(View.VISIBLE);
        List<SanPham> sanPhamList = new ArrayList<>();
        if(kiemtra){
            sanPhamList = modelHienThiSanPhamTheoDanhMuc.LayDanhSachSanPhamTheoMaLoai(masp,"DANHSACHSANPHAM","LayDanhSachSanPhamTheoMaThuongHieu",limit);
        }else{
            sanPhamList = modelHienThiSanPhamTheoDanhMuc.LayDanhSachSanPhamTheoMaLoai(masp,"DANHSACHSANPHAM","LayDanhSachSanPhamTheoMaLoaiDanhMuc",limit);
        }

        if(sanPhamList.size() != 0){
            progressBar.setVisibility(View.GONE);
        }

        return sanPhamList;
    }
}
