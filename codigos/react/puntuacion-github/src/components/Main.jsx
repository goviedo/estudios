import React from 'react'
import { Text, View } from 'react-native'
import Constants from 'expo-constants'
import Repositorio from './Repositorio'

const Main = () => {
    return (
        <View
            style={{ marginTop: Constants.statusBarHeight, flexGrow: 1 }}>
                <Text>Aplicación que puntua los repositorios de GitHub</Text>
                <Repositorio/>
        </View>
    )
}

export default Main
