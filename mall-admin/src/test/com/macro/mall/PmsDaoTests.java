package com.macro.mall;


import cn.hutool.json.JSONUtil;
import com.macro.mall.dao.PmsMemberPriceDao;
import com.macro.mall.dao.PmsProductDao;
import com.macro.mall.dto.PmsProductCategoryParam;
import com.macro.mall.dto.PmsProductResult;
import com.macro.mall.model.PmsMemberPrice;
import com.macro.mall.model.UmsAdmin;
import com.macro.mall.security.config.IgnoreUrlsConfig;
import com.macro.mall.validator.FlagValidator;
import io.swagger.models.auth.In;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.annotations.ConstructorArgs;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.temporal.ChronoField;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class PmsDaoTests {
    @Autowired
    private PmsMemberPriceDao memberPriceDao;
    @Autowired
    private PmsProductDao productDao;
    @Autowired
    private IgnoreUrlsConfig ignoreUrlsConfig;
    @Autowired
    private RedisTemplate redisTemplate;

    private static final Logger LOGGER = LoggerFactory.getLogger(PmsDaoTests.class);

    @Test
    @Transactional
    @Rollback
    public void testInsertBatch() {
        List<PmsMemberPrice> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            PmsMemberPrice memberPrice = new PmsMemberPrice();
            memberPrice.setProductId(1L);
            memberPrice.setMemberLevelId((long) (i + 1));
            memberPrice.setMemberPrice(new BigDecimal("22"));
            list.add(memberPrice);
        }
        int count = memberPriceDao.insertList(list);
        Assert.assertEquals(5, count);
    }

    @Test
    public void testGetProductUpdateInfo() {
        PmsProductResult productResult = productDao.getUpdateInfo(7L);
        String json = JSONUtil.parse(productResult).toString();
        LOGGER.info(json);
    }

}


