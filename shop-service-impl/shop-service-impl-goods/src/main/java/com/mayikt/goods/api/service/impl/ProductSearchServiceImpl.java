package com.mayikt.goods.api.service.impl;

import java.util.List;

import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.RestController;

import com.goods.api.service.GoodsSearchService;
import com.goods.output.dto.GoodsDto;
import com.mayikt.base.BaseApiService;
import com.mayikt.base.BaseResponse;
import com.mayikt.goods.es.entity.ProductEntity;
import com.mayikt.goods.es.reposiory.ProductReposiory;

import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
@RestController
public class ProductSearchServiceImpl extends BaseApiService<List<GoodsDto>> implements GoodsSearchService {
	@Autowired
	private ProductReposiory productReposiory;

	@Override
	public BaseResponse<List<GoodsDto>> search(String name,
			@PageableDefault(page = 0, value = 10) Pageable pageable) {
		String user = null;
		System.out.println(user.getBytes());
		// 1.拼接查询条件
		BoolQueryBuilder builder = QueryBuilders.boolQuery();
		// 2.模糊查询 name、 subtitle、detail含有 搜索关键字
		builder.must(QueryBuilders.multiMatchQuery(name, "name", "subtitle", "detail"));
		// 3.调用ES接口查询
		Page<ProductEntity> page = productReposiory.search(builder, pageable);
		// 4.获取集合数据
		List<ProductEntity> content = page.getContent();
		// 5.将entity转换dto
		MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
		List<GoodsDto> mapAsList = mapperFactory.getMapperFacade().mapAsList(content, GoodsDto.class);
		return setResultSuccess(mapAsList);
	}
	// 现在生产环境中 出现错误日志 如何定位
}
