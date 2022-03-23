package com.oyangc.swaggersample;

import io.github.swagger2markup.GroupBy;
import io.github.swagger2markup.Language;
import io.github.swagger2markup.Swagger2MarkupConfig;
import io.github.swagger2markup.Swagger2MarkupConverter;
import io.github.swagger2markup.builder.Swagger2MarkupConfigBuilder;
import io.github.swagger2markup.markup.builder.MarkupLanguage;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import springfox.documentation.staticdocs.SwaggerResultHandler;

import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Paths;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@AutoConfigureRestDocs(outputDir = "doc/swagger")
@SpringBootTest
public class SwaggerToMarkdownTest {

    @Autowired
    private MockMvc mockMvc;

    /**
     * 不启动服务，直接生成md
     * @throws Exception
     */
    @Test
    public void swaggerGenMd() throws Exception {
        String out = "doc/swagger";
        mockMvc.perform(MockMvcRequestBuilders.get("/v2/api-docs").accept(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andDo(SwaggerResultHandler.outputDirectory(out).build())
                .andExpect(status().isOk())
                .andReturn();

        //生成markdown的配置
        Swagger2MarkupConfig config = new Swagger2MarkupConfigBuilder()
                .withMarkupLanguage(MarkupLanguage.MARKDOWN)
                .withOutputLanguage(Language.ZH)
                .withPathsGroupedBy(GroupBy.TAGS)
                .build();

        //获取swagger.json文件，输出到outputDir中
        Swagger2MarkupConverter.from(Paths.get(out + "/swagger.json"))
                .withConfig(config)
                .build()
//                .toFolder(Paths.get(out + "/markdown"));
                .toFile(Paths.get(out + "/markdown"));
    }

    /**
     * 使用url http://localhost:8080/v2/api-docs，生成md
     * @throws MalformedURLException
     */
    @Test
    public void mdByUrl() throws MalformedURLException {
        String apiDoc = "http://localhost:8080/v2/api-docs";
//        String apiDoc = "http://localhost:9595/v2/api-docs";
        String out = "doc/swagger";
        Swagger2MarkupConfig config = new Swagger2MarkupConfigBuilder()
                .withMarkupLanguage(MarkupLanguage.MARKDOWN)
                .build();

        Swagger2MarkupConverter.from(new URL(apiDoc))
                .withConfig(config)
                .build()
//                .toFolder(Paths.get(out));
                .toFile(Paths.get(out));
    }
}