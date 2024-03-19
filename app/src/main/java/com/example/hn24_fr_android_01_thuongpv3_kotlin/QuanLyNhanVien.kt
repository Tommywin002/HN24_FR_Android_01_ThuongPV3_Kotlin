package com.example.trainingkotlin.lectures.oop

import java.util.*

class NhanVien(
    var maNhanVien: String,
    var ten: String,
    var gioiTinh: String,
    var ngaySinh: String,
    var soDienThoai: String,
    var trinhDo: String
) {
    init {

    }
    override fun toString(): String {
        return "[Ma nhan vien: $maNhanVien, Ten: $ten, Gioi tinh: $gioiTinh, Ngay sinh: $ngaySinh, SDT: $soDienThoai,  Trinh do: $trinhDo]"
    }
}

fun themNhanVien(arrNhanVien: ArrayList<NhanVien>) {
    val scanner = Scanner(System.`in`)

    print("Ten nhan vien: ")
    val ten = scanner.nextLine()

    print("Gioi tinh: ")
    var gioiTinh = ""
    while (gioiTinh != "Nam" && gioiTinh != "Nu") {
        print("Gioi tinh (Nam/Nu): ")
        gioiTinh = scanner.nextLine()
    }

    print("Ngay sinh: ")
    var ngaySinh = ""
    while (ngaySinh.length != 10 || ngaySinh[2] != '/' || ngaySinh[5] != '/') {
        print("Ngay sinh (Ngan cach nhau bang / va co 10 ki tu): ")
        ngaySinh = scanner.nextLine()
    }

    print("So dien thoai: ")
    val soDienThoai = scanner.nextLine()

    print("Trinh do: ")
    var trinhDo = ""
    while (trinhDo != "Trung cap" && trinhDo != "Cao dang" && trinhDo != "Dai hoc") {
        print("Trinh do(Trung cap/Cao dang/Dai hoc): ")
        trinhDo = scanner.nextLine()
    }

    val maNhanVien = "" + (arrNhanVien.size + 1)
    arrNhanVien.add(NhanVien(maNhanVien, ten, gioiTinh, ngaySinh, soDienThoai, trinhDo))
}

fun suaNhanVien(arrNhanVien: ArrayList<NhanVien>) {
    val scanner = Scanner(System.`in`)
    print("Nhap ma nhan vien: ")
    val maNhanVien = scanner.nextLine()
    for (nhanVien in arrNhanVien) {
        if (nhanVien.maNhanVien == maNhanVien) {
            print("Ten nhan vien: ")
            nhanVien.ten = scanner.nextLine()

            print("Gioi tinh: ")
            nhanVien.gioiTinh = ""
            while (nhanVien.gioiTinh != "Nam" && nhanVien.gioiTinh != "Nu") {
                print("Gioi tinh (Nam/Nu): ")
                nhanVien.gioiTinh = scanner.nextLine()
            }

            print("Ngay sinh: ")
            nhanVien.ngaySinh = ""
            while (nhanVien.ngaySinh.length != 10 || nhanVien.ngaySinh[2] != '/' || nhanVien.ngaySinh[5] != '/') {
                print("Ngay sinh (Ngan cach nhau bang / va co 10 ki tu): ")
                nhanVien.ngaySinh = scanner.nextLine()
            }

            print("So dien thoai: ")
            nhanVien.soDienThoai = scanner.nextLine()

            print("Trinh do: ")
            nhanVien.trinhDo = ""
            while (nhanVien.trinhDo != "Trung cap" && nhanVien.trinhDo != "Cao dang" && nhanVien.trinhDo != "Dai hoc") {
                print("Trinh do(Trung cap/Cao dang/Dai hoc): ")
                nhanVien.trinhDo = scanner.nextLine()
            }
            return
        }
    }
    println("Khong co nhan vien nao ca!")
}

fun timKiemNhanVien(arrNhanVien: ArrayList<NhanVien>) {
    val scanner = Scanner(System.`in`)
    var input: String
    while (true) {
        print("Nhap thong tin tim kiem: ")
        input = scanner.nextLine()
        if (input == "") {
            continue
        }
        var tonTaiNhanVien = false
        arrNhanVien.forEach {
            if (it.ten == input || it.maNhanVien == input) {
                tonTaiNhanVien = true
                println(it)
            }
        }
        if (!tonTaiNhanVien) {
            println("Khong co nhan vien nao ca!")
        }
        return
    }
}

fun hienThiDanhSachNhanVien(arrNhanVien: ArrayList<NhanVien>) {
    if (arrNhanVien.size == 0) {
        println("Khong co nhan vien nao ca!")
    } else {
        arrNhanVien.forEach { println(it) }
    }
}

fun main() {
    val input = Scanner(System.`in`)
    val arrNhanVien = ArrayList<NhanVien>()
    while (true) {
        print("Insert your request: ")
        when (input.nextLine()) {
            "add" -> themNhanVien(arrNhanVien)
            "display" -> hienThiDanhSachNhanVien(arrNhanVien)
            "update" -> suaNhanVien(arrNhanVien)
            "find" -> timKiemNhanVien(arrNhanVien)
            "exit" -> break
        }
    }
}
