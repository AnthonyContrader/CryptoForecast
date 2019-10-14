package it.contrader.converter;

import org.springframework.stereotype.Component;

import it.contrader.dto.CommitDTO;
import it.contrader.dto.UserDTO;
import it.contrader.model.Commit;
import it.contrader.model.User;

@Component
public class CommitConverter extends AbstractConverter<Commit, CommitDTO> {

	@Override
	public Commit toEntity(CommitDTO commitDTO) {
		Commit commit = null;
		if (commitDTO != null) {
			commit = new Commit();
			commit.setId(commitDTO.getId());
			commit.setData(commitDTO.getData());
			commit.setStars(commitDTO.getStars());
			commit.setFork(commitDTO.getFork());
			commit.setWatcher(commitDTO.getWatcher());
			commit.setCollaborators(commitDTO.getCollaborators());
			commit.setNumber(commitDTO.getNumber());
			CoinConverter cc = new CoinConverter ();
			commit.setCoin(cc.toEntityS(commitDTO.getCoinDTO()));
		}
		return commit;
	}

	@Override
	public CommitDTO toDTO(Commit commit) {
		CommitDTO commitDTO = null;
		if (commit != null) {
			commitDTO = new CommitDTO();
			commitDTO.setId(commit.getId());
			commitDTO.setData(commit.getData());
			commitDTO.setStars(commit.getStars());
			commitDTO.setFork(commit.getFork());
			commitDTO.setWatcher(commit.getWatcher());
			commitDTO.setCollaborators(commit.getCollaborators());
			commitDTO.setNumber(commit.getNumber());
			CoinConverter cc = new CoinConverter ();
			commitDTO.setCoinDTO(cc.toDTOS(commit.getCoin()));

		}
		return commitDTO;
	}
	
	@Override
	public Commit toEntityS(CommitDTO commitDTO) {

		Commit commit = null;
		if (commitDTO != null) {
			commit = new Commit();
			commit.setId(commitDTO.getId());
			commit.setData(commitDTO.getData());
			commit.setStars(commitDTO.getStars());
			commit.setFork(commitDTO.getFork());
			commit.setWatcher(commitDTO.getWatcher());
			commit.setCollaborators(commitDTO.getCollaborators());
			commit.setNumber(commitDTO.getNumber());
			CoinConverter cc = new CoinConverter ();
			commit.setCoin(cc.toEntityS(commitDTO.getCoinDTO()));
		}
		return commit;
		
	}

	@Override
	public CommitDTO toDTOS(Commit commit) {

		CommitDTO commitDTO = null;
		if (commit != null) {
			commitDTO = new CommitDTO();
			commitDTO.setId(commit.getId());
			commitDTO.setData(commit.getData());
			commitDTO.setStars(commit.getStars());
			commitDTO.setFork(commit.getFork());
			commitDTO.setWatcher(commit.getWatcher());
			commitDTO.setCollaborators(commit.getCollaborators());
			commitDTO.setNumber(commit.getNumber());
			CoinConverter cc = new CoinConverter ();
			commitDTO.setCoinDTO(cc.toDTOS(commit.getCoin()));

		}
		return commitDTO;
		
	}
	
}