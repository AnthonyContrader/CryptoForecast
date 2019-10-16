import { CoinDTO } from './coindto';


export class CommitDTO {


    id: number ;

    date: string;

    stars: number;
    
    fork: number;

    watcher: number;

    collaborators: number;
    
    number: number;

    coindto: CoinDTO;
}