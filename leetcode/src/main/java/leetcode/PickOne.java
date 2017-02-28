package leetcode;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.math.NumberUtils;

import com.fasterxml.jackson.databind.ObjectMapper;

public class PickOne {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		URL currentUrl = PickOne.class.getResource("");
		try {
			List<String> readLines = FileUtils.readLines(
					new File(currentUrl.getPath() + File.separatorChar + "leetcode.json"), Charset.defaultCharset());
			try {
				ObjectMapper objectMapper = new ObjectMapper();
				Map<?, ?> data = objectMapper.readValue(readLines.get(0), Map.class);
				ArrayList<Map<String, Object>> questions = (ArrayList<Map<String, Object>>) data
						.get("stat_status_pairs");
				int num = RandomUtils.nextInt(0, questions.size() - 1);
				Map<String, Object> map = questions.get(num);
				Map<String, Object> stat = (Map<String, Object>) map.get("stat");
				String title = (String) stat.get("question__title");
				String url = "https://leetcode.com/problems/" + stat.get("question__title_slug");
				long id = NumberUtils.toLong(stat.get("question_id").toString());
				Map<String, Object> difficulty = (Map<String, Object>) map.get("difficulty");
				int level = NumberUtils.toInt(difficulty.get("level").toString());
				System.out.println(title + ">>>>" + id + ">>>>" + level + ">>>>>>>>" + url);
				System.out.println(
						"--------------------------------------------------------------------------------------------");
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
