package com.cso.jsf2spring3.util;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Calendar;

import javax.imageio.ImageIO;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 
 * @author ouow
 * @since Aug 17, 2012
 */
public final class ImageFrameUtil {
	private static final Log log = LogFactory.getLog(ImageFrameUtil.class);
	public static final int FLASH_IMAGE_WIDTH = 500;
	public static final int FLASH_IMAGE_HEIGHT = 475;

	public static final int THUMBNAIL_IMAGE_WIDTH = 100;
	public static final int THUMBNAIL_IMAGE_HEIGHT = 95;

	public static final String IMAGE_TYPE = "png";

	private ImageFrameUtil() {
	}

	/**
	 * 
	 * @param filename
	 * @param flashfile
	 * @return
	 */
	public static boolean convertFlash(String filename, String flashfile) {
		byte[] fileBytes = getFileBytes(filename);
		if (fileBytes != null) {
			long startTime = Calendar.getInstance().getTimeInMillis();
			// scale width
			ImageFrame iu = new ImageFrame(fileBytes, FLASH_IMAGE_WIDTH,
					FLASH_IMAGE_HEIGHT, true);
			BufferedImage bi = iu.scaleImage();
			iu.saveImageFile(bi, flashfile);
			long endTime = Calendar.getInstance().getTimeInMillis();
			log
					.debug("Flash:Time cost = " + (endTime - startTime)
							+ " millis ");
			return true;
		}
		log.warn("convertFlash: nothing convert");
		return false;
	}

	/**
	 * 
	 * @param fileBytes
	 * @return
	 */
	public static byte[] convertFlash(byte[] fileBytes) {
		try {
			long startTime = Calendar.getInstance().getTimeInMillis();
			ImageFrame iu = new ImageFrame(fileBytes, FLASH_IMAGE_WIDTH,
					FLASH_IMAGE_HEIGHT, true);
			BufferedImage bi = iu.scale2DImage();
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ImageIO.write(bi, IMAGE_TYPE, baos);
			baos.flush();
			byte[] imageBytes = baos.toByteArray();
			baos.close();
			long endTime = Calendar.getInstance().getTimeInMillis();
			log.debug("Thumbnail:Time cost = " + (endTime - startTime)
					+ " millis ");
			return imageBytes;
		} catch (IOException e) {
			log.error(e.getMessage());
			e.printStackTrace();
		}
		log.warn("convertFlash: nothing convert");
		return fileBytes;
	}

	/**
	 * 
	 * @param filename
	 * @param thumbnail
	 * @return
	 */
	public static boolean convertThumbnail(String filename, String thumbnailfile) {
		byte[] fileBytes = getFileBytes(filename);
		if (fileBytes != null) {
			long startTime = Calendar.getInstance().getTimeInMillis();

			ImageFrame iu = new ImageFrame(fileBytes, THUMBNAIL_IMAGE_WIDTH,
					THUMBNAIL_IMAGE_HEIGHT, false);
			BufferedImage bi = iu.scale2DImage();
			iu.saveImageFile(bi, thumbnailfile);
			long endTime = Calendar.getInstance().getTimeInMillis();
			log.debug("Thumbnail:Time cost = " + (endTime - startTime)
					+ " millis ");
			return true;
		}
		log.warn("convertFlash: nothing convert");
		return false;
	}

	/**
	 * 
	 * @param fileBytes
	 * @return
	 */
	public static byte[] convertThumbnail(byte[] fileBytes) {
		try {
			long startTime = Calendar.getInstance().getTimeInMillis();
			ImageFrame iu = new ImageFrame(fileBytes, THUMBNAIL_IMAGE_WIDTH,
					THUMBNAIL_IMAGE_HEIGHT, false);
			BufferedImage bi = iu.scale2DImage();
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ImageIO.write(bi, IMAGE_TYPE, baos);
			baos.flush();
			byte[] imageBytes = baos.toByteArray();
			baos.close();
			long endTime = Calendar.getInstance().getTimeInMillis();
			log.debug("Thumbnail:Time cost = " + (endTime - startTime)
					+ " millis ");
			return imageBytes;
		} catch (IOException e) {
			log.error(e.getMessage());
			e.printStackTrace();
		}
		log.warn("convertFlash: nothing convert");
		return fileBytes;
	}

	/**
	 * 
	 * @param filename
	 * @return
	 */
	public static byte[] getFileBytes(String filename) {
		try {
			long startTime = Calendar.getInstance().getTimeInMillis();
			File file = new File(filename);
			FileInputStream fin = new FileInputStream(file);
			byte[] fileBytes = new byte[(int) file.length()];
			fin.read(fileBytes);
			long endTime = Calendar.getInstance().getTimeInMillis();
			log.debug("getImageBytes:Time cost = " + (endTime - startTime)
					+ " millis ");
			return fileBytes;
		} catch (FileNotFoundException fnfe) {
			log.error(fnfe.getMessage());
			fnfe.printStackTrace();
		} catch (IOException ioe) {
			log.error(ioe.getMessage());
			ioe.printStackTrace();
		}
		return null;
	}
}
