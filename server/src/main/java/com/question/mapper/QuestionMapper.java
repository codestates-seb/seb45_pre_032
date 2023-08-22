// QuestionEntity와 QuestionDto 간의 매핑을 담당하는 문서임


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper  // MapStruct 매퍼 인터페이스임을 나타내는 어노테이션
public interface QuestionMapper {

    QuestionMapper INSTANCE = Mappers.getMapper(QuestionMapper.class);

    // QuestionEntity를 QuestionDto로 매핑하는 메소드
    @Mapping(target = "created_at", source = "created_at", dateFormat = "yyyy-MM-dd HH:mm:ss")
    @Mapping(target = "modified_at", source = "modified_at", dateFormat = "yyyy-MM-dd HH:mm:ss")
    // dateFormat 속성을 사용하여 날짜 형식을 지정
    QuestionDto toDto(QuestionEntity entity);

    // QuestionDto를 QuestionEntity로 매핑하는 메소드
    @Mapping(target = "created_at", ignore = true)
    @Mapping(target = "modified_at", ignore = true)
    // created_at과 modified_at 필드를 무시(ignore)하여 엔터티에 자동으로 할당되도록 함
    QuestionEntity toEntity(QuestionDto dto);
}
