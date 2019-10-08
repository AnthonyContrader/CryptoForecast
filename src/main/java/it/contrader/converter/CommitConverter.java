package it.contrader.converter;

import org.springframework.stereotype.Component;

import it.contrader.dto.CommitDTO;

import it.contrader.model.Commit;

@Component
public class CommitConverter extends AbstractConverter<Commit, CommitDTO> {

	@Override
	public Commit toEntity(CommitDTO commitDTO) {
		Commit commit = null;
		if (commitDTO != null) {
			commit = new Commit(commitDTO.getId(), commitDTO.getStars(), commitDTO.getFork(), commitDTO.getWatcher(), commitDTO.getCollaborators(), commitDTO.getNumber());
		}
		return commit;
	}

	@Override
	public CommitDTO toDTO(Commit commit) {
		CommitDTO commitDTO = null;
		if (commit != null) {
			commitDTO = new CommitDTO(commit.getId(), commit.getStars(), commit.getFork(), commit.getWatcher(), commit.getCollaborators(), commit.getNumber());

		}
		return commitDTO;
	}
}