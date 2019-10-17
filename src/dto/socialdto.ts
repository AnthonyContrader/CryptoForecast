import { CoinDTO } from './coindto';



export class SocialDTO{

    id: number;
    date: string;
    reddit: number;
    telegram: number;
    likefb: number;
    twitter: number;

    coin: CoinDTO;
}