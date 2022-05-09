import graphql.language.FieldDefinition;
import graphql.language.ObjectTypeDefinition;
import graphql.language.TypeDefinition;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * description :
 *
 * @author songhaifeng
 * @date 2022/5/7 23:30
 */
@Slf4j
public class SchemaParserTest {
    @Test
    public void schemaParserTest() throws IOException {
        TypeDefinitionRegistry typeDefinitionRegistry = new SchemaParser().parse(new ClassPathResource("schema/schema.graphqls").getFile());
        Map<String, TypeDefinition> map = typeDefinitionRegistry.types();
        log.info("{}", map.keySet());
        Optional<TypeDefinition> queries = typeDefinitionRegistry.getType("Query");
        queries.ifPresent(query -> {
            log.info("Query Definition", map.keySet());
            if (query instanceof ObjectTypeDefinition) {
                ObjectTypeDefinition typeDefinition = (ObjectTypeDefinition) query;
                List<FieldDefinition> fieldDefinitions = typeDefinition.getFieldDefinitions();
                fieldDefinitions.forEach(fieldDefinition -> {
                    log.info("name -> {}, input -> {}, returnType -> {}", fieldDefinition.getName(), fieldDefinition.getInputValueDefinitions(), fieldDefinition.getType());
                });
            }
        });
    }
}
