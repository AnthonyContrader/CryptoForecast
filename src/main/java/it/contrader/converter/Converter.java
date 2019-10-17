package it.contrader.converter;

import java.util.List;

public interface Converter<Entity, DTO> {

	public Entity toEntity(DTO dto);

	public DTO toDTO(Entity entity);
	
	/*public Entity toEntityS(DTO dto);

	public DTO toDTOS(Entity entity);
*/
	public List<DTO> toDTOList(Iterable<Entity> entityList);
	
	//public List<Entity> toEntityList(Iterable<DTO> dtoList);

}