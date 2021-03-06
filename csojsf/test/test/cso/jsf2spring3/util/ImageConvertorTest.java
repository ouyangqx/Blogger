package test.cso.jsf2spring3.util;

import junit.framework.TestCase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.cso.jsf2spring3.util.ImageConvertorUtil;

public class ImageConvertorTest extends TestCase {
	private static final Log log = LogFactory.getLog(ImageConvertorTest.class);

	public static final String TEST_IMAGE_1 = "c:/temp/hp_pic_1.jpg";
	public static final String TEST_FLASH_IMAGE_1 = "c:/temp/hp_pic_1_flash.jpg";
	public static final String TEST_THUMBNAIL_IMAGE_1 = "c:/temp/hp_pic_1_thumb.jpg";
	public static final String TEST_IMAGE_2 = "c:/temp/hp_pic_2.jpg";
	public static final String TEST_FLASH_IMAGE_2 = "c:/temp/hp_pic_2_flash.jpg";
	public static final String TEST_THUMBNAIL_IMAGE_2 = "c:/temp/hp_pic_2_thumb.jpg";

	@Override
	public void setUp() {
	}

	public void testImageConvertorUtil() {
		log.debug(">>testImageConvertorUtil()");
		ImageConvertorUtil.convertFlash(TEST_IMAGE_1, TEST_FLASH_IMAGE_1);
		ImageConvertorUtil.convertThumbnail(TEST_IMAGE_1, TEST_THUMBNAIL_IMAGE_1);
		ImageConvertorUtil.convertFlash(TEST_IMAGE_2, TEST_FLASH_IMAGE_2);
		ImageConvertorUtil.convertThumbnail(TEST_IMAGE_2, TEST_THUMBNAIL_IMAGE_2);
		log.debug("<<testImageConvertorUtil()");
	}

}
