package com.rgnews.model;

import lombok.Data;
import java.util.HashMap;
import java.io.Serializable;

@Data
public class Result implements Serializable {


    private int code;
    private String msg;
    private Object data;





        public Result() {

        }

        public Result(int code,String msg,Object data) {
            this.code = code;
            this.msg = msg;
            this.data = data;
        }

        public static Result newInstance(int code,String msg,Object data){
            return new Result(code,msg,data);
        }

        public static Result newInstance(int code,String msg){
            return new Result(code,msg,null);
        }

        /**
         * 在map中存放多个数据
         * @param key
         * @param data
         */
        public Result putData(String key, Object data) {
            if (this.data == null || !(data instanceof HashMap)) {
                this.data = new HashMap<String, Object>();
            }
            ((HashMap<String, Object>) this.data).put(key, data);
            return this;
        }

        /**
         * 在map中清除数据
         * @param key
         */
        public Result removeData(String key){
            if(data != null && data instanceof HashMap){
                ((HashMap<String,Object>)data).remove(key);
            }
            return this;
        }

        /**
         * 设置错误的状态码
         * @param CODE
         */
        public Result setCode(ResultCode CODE) {
            this.code = CODE.getCode();
            this.msg = CODE.getMsg();
            return this;
        }

        /**
         * 设置状态码和数据
         * @param CODE
         * @param data
         */
        public Result setCode(ResultCode CODE, Object data) {
            this.code = CODE.getCode();
            this.msg = CODE.getMsg();
            this.data = data;
            return this;
        }


        public Result setException(Exception e){
            if(e != null) {
                this.setCode(ResultCode.FAILED.getCode());
                this.setMsg(e.getMessage());
            }
            return this;
        }

        public static Result success(){
            return new Result(ResultCode.SUCCESS.getCode(),ResultCode.SUCCESS.getMsg(),null);
        }

        public static Result success(Object data){
            return new Result(ResultCode.SUCCESS.getCode(),ResultCode.SUCCESS.getMsg(),data);
        }


        public static Result success(Object data,String msg){
            return new Result(ResultCode.SUCCESS.getCode(),msg,data);
        }


        public static Result failed(){
            return new Result(ResultCode.FAILED.getCode(),ResultCode.FAILED.getMsg(),null);
        }

        public static Result failed(String msg){
            return new Result(ResultCode.FAILED.getCode(),msg,null);
        }

        public static Result failed(int code,String msg){
            return new Result(code,msg,null);
        }

        public static Result parameterError(){
            return new Result(ResultCode.PARAMETER_ERROR.getCode(),ResultCode.PARAMETER_ERROR.getMsg(),null);
        }

        public static Result forbidden(){
            return new Result(ResultCode.FORBIDDEN.getCode(),ResultCode.FORBIDDEN.getMsg(),null);
        }


        public int getCode() {
            return code;
        }

        public Result setCode(int code) {
            this.code = code;
            return this;
        }

        public String getMsg() {
            return msg;
        }

        public Result setMsg(String msg) {
            this.msg = msg;
            return this;
        }

        public Object getData() {
            return data;
        }

        public Result setData(Object data) {
            this.data = data;
            return this;
        }


}
