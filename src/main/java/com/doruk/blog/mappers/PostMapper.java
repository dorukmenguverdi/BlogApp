package com.doruk.blog.mappers;

import com.doruk.blog.domain.CreatePostRequest;
import com.doruk.blog.domain.UpdatePostRequest;
import com.doruk.blog.domain.dtos.CreatePostRequestDto;
import com.doruk.blog.domain.dtos.PostDto;
import com.doruk.blog.domain.dtos.UpdatePostRequestDto;
import com.doruk.blog.domain.entities.Post;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface PostMapper {

    // Entity -> DTO
    @Mapping(target = "author",   source = "author")
    @Mapping(target = "category", source = "category")
    @Mapping(target = "tags",     source = "tags")
    @Mapping(target = "status",   source = "status")
    PostDto toDto(Post post);

    // Create DTO -> Create command
    @Mapping(target = "title",      source = "title")
    @Mapping(target = "content",    source = "content")
    @Mapping(target = "categoryId", source = "categoryId")
    @Mapping(target = "tagIds",     source = "tagIds")
    @Mapping(target = "status",     source = "status")
    CreatePostRequest toCreatePostRequest(CreatePostRequestDto dto);

    // Update DTO -> Update command
    @Mapping(target = "id",         source = "id")
    @Mapping(target = "title",      source = "title")
    @Mapping(target = "content",    source = "content")
    @Mapping(target = "categoryId", source = "categoryId")
    @Mapping(target = "tagIds",     source = "tagIds")
    @Mapping(target = "status",     source = "status")
    UpdatePostRequest toUpdatePostRequest(UpdatePostRequestDto dto);
}