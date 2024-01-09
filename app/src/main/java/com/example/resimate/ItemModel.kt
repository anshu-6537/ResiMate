package com.example.resimate



class ItemModel (var course_name: String, var imgid: Int) {

        @JvmName("getCourse_name1")
        fun getCourse_name(): String {
            return course_name
        }

        @JvmName("setCourse_name1")
        fun setCourse_name(course_name: String) {
            this.course_name = course_name
        }

        @JvmName("getImgid1")
        fun getImgid(): Int {
            return imgid
        }

        @JvmName("setImgid1")
        fun setImgid(imgid: Int) {
            this.imgid = imgid
        }
    }