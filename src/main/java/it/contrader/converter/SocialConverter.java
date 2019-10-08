package it.contrader.converter;

import org.springframework.stereotype.Component;

import it.contrader.dto.SocialDTO;

import it.contrader.model.Social;

@Component
public class SocialConverter extends AbstractConverter<Social, SocialDTO> {

	@Override
	public Social toEntity(SocialDTO socialDTO) {
		Social social = null;
		if (socialDTO != null) {
			social = new Social(socialDTO.getId(), socialDTO.getReddit(), socialDTO.getTelegram(),socialDTO.getTwitter(), socialDTO.getLikefb());
		}
		return social;
	}

	@Override
	public SocialDTO toDTO(Social social) {
		SocialDTO socialDTO = null;
		if (social != null) {
			socialDTO = new SocialDTO(social.getId(), social.getReddit(), social.getTelegram(), social.getLikefb(),social.getTwitter() );

		}
		return socialDTO;
	}
}