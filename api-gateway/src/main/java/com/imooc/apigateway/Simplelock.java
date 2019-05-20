//package com.study.demo;
//
//import redis.clients.jedis.Jedis;
//import redis.clients.jedis.Transaction;
//
//import java.util.UUID;
//
///**
// * @ClassName Simplelock
// * @Description TODO redis锁
// * @Author 99795
// * @DaTe 2019/5/19 15:44
// * @Version 1.0
// **/
//public class Simplelock {
//
//     Jedis coon=new Jedis("127.0.0.1",6379);
//
//    private final String LOCK_NAME="lock";
//    //获得锁 重入锁
//    public  String accquireLock(int timeOut){
//        String uuid= UUID.randomUUID().toString();
//        long end =System.currentTimeMillis()+timeOut;
//        while (System.currentTimeMillis()<end){
//            if (coon.setnx(LOCK_NAME,uuid).intValue()==1){
//                return  uuid;
//            }
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//        return null;
//    }
//
//    //释放锁
//    public boolean releaseLock(String uuid){
//        while (true){
//            coon.watch(LOCK_NAME);  //监控锁变化
//            if(uuid.equals(coon.get(LOCK_NAME))){
//                Transaction transaction=coon.multi();
//                transaction.del(LOCK_NAME);
//                if (transaction.exec() == null){
//                    continue;
//                }
//                return true;
//            }
//            coon.unwatch();
//            break;
//        }
//        return false;
//    }
//
//    public static void main(String[] args) {
//        Simplelock simplelock=new Simplelock();
//        String uuid=simplelock.accquireLock(4000);
//        if (uuid!=null){
//            System.out.println("1  获得成功");
//        }else {
//            System.out.println("1   获得失败");
//        }
//        Simplelock simplelock2=new Simplelock();
//        String uuid2=simplelock2.accquireLock(4000);
//        if (uuid2!=null){
//            System.out.println("2  获得成功");
//        }else {
//            System.out.println("2  获得失败");
//        }
//    }
//}
