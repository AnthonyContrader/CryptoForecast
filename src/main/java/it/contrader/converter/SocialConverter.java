package it.contrader.converter;

import org.springframework.stereotype.Component;

import it.contrader.dto.SocialDTO;
import it.contrader.dto.UserDTO;
import it.contrader.model.Social;
import it.contrader.model.User;

@Component
public class SocialConverter extends AbstractConverter<Social, SocialDTO> {

	@Override
	public Social toEntity(SocialDTO socialDTO) {
		Social social = null;
		if (socialDTO != null) {
			//social = new Social(socialDTO.getId(), socialDTO.getReddit(), socialDTO.getTelegram(),socialDTO.getTwitter(), socialDTO.getLikefb());
		social = new Social();
		social.setId(socialDTO.getId());
		social.setDate(socialDTO.getDate());
		social.setReddit(socialDTO.getReddit());
		social.setTelegram(socialDTO.getTelegram());
		social.setLikefb(socialDTO.getLikefb());
		social.setTwitter(socialDTO.getTwitter());
		social.setCoin(socialDTO.getCoin());
	//	CoinConverter cc = new CoinConverter();
	//	social.setCoin(cc.toEntityS(socialDTO.getCoinDTO()));
		
		
		}
		return social;
	}

	@Override
	public SocialDTO toDTO(Social social) {
		SocialDTO socialDTO = null;
		if (social != null) {
			//socialDTO = new SocialDTO(social.getId(), social.getReddit(), social.getTelegram(), social.getLikefb(),social.getTwitter() );

			socialDTO = new SocialDTO();
			socialDTO.setId(social.getId());
			socialDTO.setDate(social.getDate());
			socialDTO.setReddit(social.getReddit());
			socialDTO.setTelegram(social.getTelegram());
			socialDTO.setLikefb(social.getLikefb());
			socialDTO.setTwitter(social.getTwitter());
			socialDTO.setCoin(social.getCoin());
			//CoinConverter cc = new CoinConverter();
		//	socialDTO.setCoinDTO(cc.toDTOS(social.getCoin()));
			
		}
		return socialDTO;
	}
	/*
	@Override
	public Social toEntityS(SocialDTO socialDTO) {


		Social social = null;
		if (socialDTO != null) {
			//social = new Social(socialDTO.getId(), socialDTO.getReddit(), socialDTO.getTelegram(),socialDTO.getTwitter(), socialDTO.getLikefb());
			social = new Social();
			social.setId(socialDTO.getId());
			social.setDate(socialDTO.getDate());
			social.setReddit(socialDTO.getReddit());
			social.setTelegram(socialDTO.getTelegram());
			social.setLikefb(socialDTO.getLikefb());
			social.setTwitter(socialDTO.getTwitter());
			CoinConverter cc = new CoinConverter();
			social.setCoin(cc.toEntityS(socialDTO.getCoinDTO()));
			
		
		}
		return social;
		
	}

	@Override
	public SocialDTO toDTOS(Social social) {
		
		
		SocialDTO socialDTO = null;
		if (social != null) {
			//socialDTO = new SocialDTO(social.getId(), social.getReddit(), social.getTelegram(), social.getLikefb(),social.getTwitter() );

			socialDTO = new SocialDTO();
			socialDTO.setId(social.getId());
			socialDTO.setDate(social.getDate());
			socialDTO.setReddit(social.getReddit());
			socialDTO.setTelegram(social.getTelegram());
			socialDTO.setLikefb(social.getLikefb());
			socialDTO.setTwitter(social.getTwitter());
			CoinConverter cc = new CoinConverter();
			socialDTO.setCoinDTO(cc.toDTOS(social.getCoin()));
			
		}
		return socialDTO;
		
	}*/
	
}