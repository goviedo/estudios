import { View, Text, FlatList } from 'react-native'
import repositories from '../data/repositories.js'


const Repositorio = () => {
    return (
        <View>
            {
                repositories.map(repo=>(
                    FlatList
                    
                    
                    <View
                        key={repo.id}>
                            <Text>{repo.id}</Text>
                            <Text>{repo.fullName}</Text>
                            <Text>{repo.description}</Text>
                            <Text>{repo.language}</Text>
                            <Text>{repo.stargazersCount}</Text>
                            <Text>{repo.ratingAverage}</Text>
                            <Text>{repo.reviewCount}</Text>
                            <Text>{repo.ownerAvatarUrl}</Text>
                    </View>
                ))
            }
        </View>
    )
}

export default Repositorio;