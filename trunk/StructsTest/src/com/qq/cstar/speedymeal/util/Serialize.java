package com.qq.cstar.speedymeal.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import com.qq.cstar.speedymeal.entity.Location;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class Serialize {
	/**
	 * 序列化对象为String字符串
	 * 
	 * @param o
	 *            Object
	 * @return String
	 * @throws Exception
	 */
	public static String writeObject(Object o) throws Exception {
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(bos);
		oos.writeObject(o);
		oos.flush();
		oos.close();
		bos.close();
		return new BASE64Encoder().encode(bos.toByteArray());
	}

	/**
	 * 反序列化字符串为对象
	 * 
	 * @param s
	 *            String
	 * @return
	 * @throws Exception
	 */
	public static Object readObject(String s) throws Exception {
		ByteArrayInputStream bis = new ByteArrayInputStream(new BASE64Decoder().decodeBuffer(s));
		ObjectInputStream ois = new ObjectInputStream(bis);
		Object o = ois.readObject();
		bis.close();
		ois.close();
		return o;
	}

	public static void main(String[] args) {

		Location l = new Location(12.3, 15.3);

		ArrayList<Location> ar = new ArrayList<Location>();
		String s = null;
		try {
			s = Serialize.writeObject(ar);
			System.out.println(s);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(s);
		Location ss = null;
		try {
			ss = (Location) Serialize.readObject(s);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(ss.toString());

	}
}
